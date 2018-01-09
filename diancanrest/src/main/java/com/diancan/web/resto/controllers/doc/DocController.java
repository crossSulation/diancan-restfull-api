package com.diancan.web.resto.controllers.doc;

import com.diancan.domain.resto.mongo.Doc;
import com.diancan.service.resto.doc.DocServiceImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/docs")
@Api(value = "docs",description = "doc files management")
public class DocController {

    @Autowired
    DocServiceImpl docService;


    /**
     *
     * @param docId
     * @return
     */
    @ApiOperation("Get one docs by given id")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "docId",name = "docId",required = true,dataType = "String",paramType = "path"),
            @ApiImplicitParam(value = "username",name = "username",dataType = "String",paramType = "header")
    })
    @GetMapping("/{docId}")
    public ResponseEntity<DocResponse> getOneFileById(
            @PathVariable(value = "docId",name = "docId") String docId,
            @RequestHeader(value = "username",required = false) String useranme) {
        Doc doc =docService.findOneById(docId);
        if(doc==null) {
            DocResponse docResponse =new DocResponse(HttpStatus.BAD_REQUEST.value(),"the file you specific is not exits!");
            return ResponseEntity.badRequest().body(docResponse);
        }
        DocResponse docResponse =docService.mapSingleDocToResponse(doc,HttpStatus.OK,"file is existed!");
        return ResponseEntity.ok(docResponse);
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
    @ApiOperation("upgrade single file")
    @PutMapping("/single/{docId}")
    public  ResponseEntity<DocResponse> updateOne(
            @PathVariable(name="docId",value = "docId") String docId,
            @RequestParam(name = "file",value = "file") MultipartFile file,
            @RequestHeader(name = "username",value = "username") String userName,
            @RequestHeader(name = "password",value = "password") String password) throws Exception {
        if(file.isEmpty()) {
            DocResponse docResponse =new DocResponse(HttpStatus.BAD_REQUEST.value(),"no file is selected");
            return ResponseEntity.badRequest().body(docResponse);
        }
        Doc doc = docService.findOneById(docId);
        if(doc ==null) {
            DocResponse docResponse =new DocResponse(HttpStatus.BAD_REQUEST.value(),"the file you specific is not exits!");
            return ResponseEntity.badRequest().body(docResponse);
        }

        doc = docService.updateDoc(docId,file,userName,password);

        docService.uploadOneFile(doc);
        DocResponse docResponse =docService.mapSingleDocToResponse(doc,HttpStatus.OK,"upgrade file successfully!");
        return ResponseEntity.ok(docResponse);
    }

    /**
     *
     * @param docId
     * @return
     */
    @ApiOperation("delete one file by given id")
    @DeleteMapping("/{docId}")
    public ResponseEntity<DocResponse> deleteOne(
            @PathVariable(value = "docId",name = "docId") String docId,
            @RequestHeader(value = "username",required = false) String username) {
         docService.deleteOneById(docId);
         DocResponse docResponse =new DocResponse(HttpStatus.OK.value(),"the file has been deleted");
        return  ResponseEntity.ok(docResponse);
    }

    @ApiOperation("upload single file")
    @RequestMapping(value = "/upload/single",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DocResponse> uploadFile (
           @RequestParam(value = "file",name = "file") MultipartFile file,
           @RequestParam(value = "username",name = "username",required = false) String username,
           @RequestParam(value = "password",name = "password",required = false) String password) throws Exception {
        if(file.isEmpty()) {
            DocResponse docResponse = new DocResponse(HttpStatus.BAD_REQUEST.value(),"you must specific one file");
            return ResponseEntity.badRequest().body(docResponse);
        }
        Doc doc = docService.createDoc(file,username,password);

        docService.uploadOneFile(doc);

        DocResponse docResponse =docService.mapSingleDocToResponse(doc,HttpStatus.OK,"the file has uploaded successfully!");

        return ResponseEntity.ok(docResponse);
    }

    @ApiOperation("upload multiple files")
    @RequestMapping(value = "/upload/multiple",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DocResponse>> uploadMutiple(
           @RequestParam(value = "file",name = "file") List<MultipartFile> files,
           @RequestParam(value = "username",name = "username") String username,
           @RequestParam(value = "password",name = "password") String password) throws Exception {

        if(files.size() <0 || files==null) {
            DocResponse docResponse = new DocResponse(HttpStatus.BAD_REQUEST.value(),"没有选择文件");
            List<DocResponse> docResponses  = new ArrayList<DocResponse>();
            docResponses.add(docResponse);
            return ResponseEntity.badRequest().body(docResponses);
        }
        List<Doc> docs = docService.createMultipleDocs(files,username,password);

        docService.uploadMultipleFile(docs);

        List<DocResponse> docResponses  = docService.mapMultipleDocsToResponse(docs,HttpStatus.OK,"the files has uploaded successfully!");
        return ResponseEntity.ok(docResponses);
    }

    @ApiOperation("get all docs")
    @GetMapping
    public ResponseEntity<List<DocResponse>> getAllDocs() {

        List<Doc> files =docService.findAll();

        List<DocResponse> docResponses =docService.mapMultipleDocsToResponse(files,HttpStatus.OK,"the query is successfully!");
        return ResponseEntity.ok(docResponses);
    }
}
