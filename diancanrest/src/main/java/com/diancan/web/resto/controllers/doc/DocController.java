package com.diancan.web.resto.controllers.doc;

import com.diancan.domain.resto.mongo.DocFile;
import com.diancan.service.resto.doc.DocServiceImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/docs")
@Api(value = "docs",description = "doc hub description")
public class DocController {

    @Autowired
    DocServiceImpl docService;


    /**
     *
     * @param docId
     * @return
     */
    @ApiOperation(value = "通过指定docId获取文件",notes = "")
    @ApiImplicitParam(value = "docId",name="docId",dataType = "String", paramType = "path",defaultValue = "")
    @GetMapping("/{docId}")
    public ResponseEntity<?> getOneImageFileById(
            @PathVariable(value = "docId",name = "docId") String docId) {
        DocFile docFile  =docService.findOneById(docId);
        return ResponseEntity.ok(docFile);
    }

    /**
     *
     * @param docId
     * @param file
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @ApiOperation(value = "通过id更新文件",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam( value = "docId",name="docId",dataType = "String", paramType = "path",defaultValue = ""),
            @ApiImplicitParam(value = "file",name = "file",dataType = "MultipartFile",paramType = "body",required = true),
            @ApiImplicitParam(value = "username",name = "username",dataType = "String",paramType = "param",required = true),
            @ApiImplicitParam(value = "password",name = "password",dataType = "String",paramType = "param",required = true)})
    @PutMapping("/single/{docId}")
    public  ResponseEntity updateOne(
            @PathVariable(name="docId",value = "docId") String docId,
            @RequestParam(name = "file",value = "file") MultipartFile file,
            @RequestParam(name = "username",value = "username") String userName,
            @RequestParam(name = "password",value = "password") String password) throws Exception {
        if(file.isEmpty()) {
            DocResponse docResponse =new DocResponse(HttpStatus.BAD_REQUEST.value(),"no file is selected");
            return ResponseEntity.badRequest().body(docResponse);
        }
        DocFile docFile = docService.findOneById(docId);
        if(docFile==null) {
            DocResponse docResponse =new DocResponse(HttpStatus.BAD_REQUEST.value(),"the file you specific is not exits!");
            return ResponseEntity.badRequest().body(docResponse);
        }
        DBObject meteData = new BasicDBObject();
        meteData.put("user",userName);
        meteData.put("pwd",password);
        docFile.setContentType(file.getContentType());
        docFile.setFileName(file.getOriginalFilename());
        docFile.setModifiedBy(userName);
        docFile.setUploadDate(System.nanoTime());
        docFile.setSize(file.getSize());
        docFile.setData(file.getBytes());
        docFile.setMetaData(meteData);
        docService.uploadOneFile(docFile);
        return new ResponseEntity<>(docFile,HttpStatus.ACCEPTED);
    }

    /**
     *
     * @param docId
     * @return
     */
    @ApiOperation(value = "通过指定docId删除文件",notes = "")
    @ApiImplicitParam(value = "docId",name="docId",dataType = "String", paramType = "path",defaultValue = "")
    @DeleteMapping("/{docId}")
    public ResponseEntity<?> deleteOne(
            @PathVariable(value = "docId",name = "docId") String docId) {
         docService.deleteOneById(docId);
         DocResponse docResponse =new DocResponse(HttpStatus.ACCEPTED.value(),"the file has been deleted");
        return  ResponseEntity.ok(docResponse);
    }

    @ApiOperation(value = "上传单个文件",notes = "")
   @ApiImplicitParams({
           @ApiImplicitParam(value = "file",name="file",dataType = "MultipartFile", paramType = "body",defaultValue = "null",required = true),
           @ApiImplicitParam(value = "username",name="username",dataType = "String", paramType = "param",required = true),
           @ApiImplicitParam(value = "password",name="password",dataType = "String", paramType = "param",required = true)})
    @RequestMapping(value = "/doc/upload/single",method = RequestMethod.POST)
    public ResponseEntity<?> uploadFile (
           @RequestParam(value = "file",name = "file") MultipartFile file,
           @RequestParam(value = "username",name = "username",required = false) String username,
           @RequestParam(value = "password",name = "password",required = false) String password) throws Exception {
        if(file.isEmpty()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        DocFile docFile = new DocFile();
        DBObject meteData = new BasicDBObject();
        meteData.put("user",username);
        meteData.put("pwd",password);
        docFile.setContentType(file.getContentType());
        docFile.setFileName(file.getOriginalFilename());
        docFile.setModifiedBy(username);
        docFile.setUploadDate(System.nanoTime());
        docFile.setSize(file.getSize());
        docFile.setData(file.getBytes());
        docFile.setMetaData(meteData);
        docService.uploadOneFile(docFile);
        return ResponseEntity.ok(docFile);
    }

    @ApiOperation(value = "上传多个文件",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "files",name="files",dataType = "List", paramType = "body",defaultValue = "null",required = true),
            @ApiImplicitParam(value = "username",name="username",dataType = "String", paramType = "param",required = true),
            @ApiImplicitParam(value = "password",name="password",dataType = "String", paramType = "param",required = true)})
    @RequestMapping(value = "/upload/multiple",method = RequestMethod.POST)
    public ResponseEntity<?> uploadMutiple(
           @RequestParam(value = "files",name = "files") List<MultipartFile> files,
           @RequestParam(value = "username",name = "username") String username,
           @RequestParam(value = "password",name = "password") String password) throws Exception {

        if(files.size() <0 || files==null) {
            DocResponse docResponse = new DocResponse(HttpStatus.BAD_REQUEST.value(),"没有选择文件");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new DocResponse());
        }
        List<DocFile> docFiles = new ArrayList<>();
        for(MultipartFile file : files) {
            DocFile docFile =new DocFile();
            DBObject meteData = new BasicDBObject();
            meteData.put("user",username);
            meteData.put("pwd",password);
            docFile.setContentType(file.getContentType());
            docFile.setFileName(file.getOriginalFilename());
            docFile.setModifiedBy(username);
            docFile.setUploadDate(System.nanoTime());
            docFile.setSize(file.getSize());
            docFile.setData(file.getBytes());
            docFile.setMetaData(meteData);
            docFiles.add(docFile);
        }

        docService.uploadMultipleFile(docFiles);
        return ResponseEntity.ok(docFiles);
    }

    @ApiOperation(value = "获取所有文件",notes = "")
    @GetMapping
    public ResponseEntity<?> getAllDocs() {

        List<DocFile> files =docService.findAll();

        return ResponseEntity.ok(files);
    }
}
