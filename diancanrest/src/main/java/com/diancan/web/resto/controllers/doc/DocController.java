package com.diancan.web.resto.controllers.doc;

import com.diancan.domain.resto.mongo.DocFile;
import com.diancan.service.resto.doc.DocServiceImpl;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dochub")
@Api(value = "dcobub")
public class DocController {

    @Autowired
    DocServiceImpl docService;

    @GetMapping("/doc/{/docId}")
    public ResponseEntity<?> getOneImageFileById(String docId) {
        DocFile docFile  =docService.findOneById(docId);
        return ResponseEntity.ok(docFile);
    }

    @PutMapping("/doc/single")
    public  ResponseEntity updateOne(
            @RequestParam(name = "file",value = "file") MultipartFile file,
            @RequestParam(name = "username",value = "username") String userName,
            @RequestParam(name = "password",value = "password") String password) throws Exception {
        if(file.isEmpty()) {
            DocResponse docResponse =new DocResponse(HttpStatus.BAD_REQUEST.value(),"no file is selected");
            return ResponseEntity.badRequest().body(docResponse);
        }
        DocFile docFile = new DocFile();
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

    @DeleteMapping("/doc/{docId}")
    public ResponseEntity<?> deleteOne(
            @PathVariable(value = "docId",name = "docId") String docId) {
         docService.deleteOneById(docId);
         DocResponse docResponse =new DocResponse(HttpStatus.ACCEPTED.value(),"the file has been deleted");
        return  ResponseEntity.ok(docResponse);
    }

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

    @RequestMapping(value = "/doc/upload/multiple",method = RequestMethod.POST)
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
}
