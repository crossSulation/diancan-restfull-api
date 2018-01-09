package com.diancan.service.resto.doc;

import com.diancan.domain.resto.mongo.Doc;
import com.diancan.respositorys.mongo.doc.DocRepository;
import com.diancan.web.resto.controllers.doc.DocResponse;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DocServiceImpl implements DocService {

    @Autowired
    FileService fileService;

    @Autowired
    DocRepository docRepository;

    @Override
    public Doc findOneById(String id) {
        return docRepository.findOneByFileId(id);
    }

    @Override
    public void deleteOneById(String id) {
        docRepository.deleteDocByFileId(id);
        fileService.deleteOneFileById(id);
    }

    @Override
    public void deleteMultipleByGiveIds(List<String> ids) {
        docRepository.deleteMutipleByGivenIds(ids);
       fileService.deleteMultipleFile(ids);
    }

    @Override
    public void uploadOneFile(Doc file) {

        InputStream inputStream = new ByteArrayInputStream(file.getData());
        String newFileId= fileService.createFile(inputStream,file.getFileName(),file.getContentType(),file.getMetaData());
        file.setFileId(newFileId);
        docRepository.save(file);
    }

    @Override
    public GridFSDBFile downloadOneFile(String id) {
        Doc file = docRepository.findOneByFileId(id);
        if(file==null) {
            return null;
        }
       return fileService.getOneFileById(id);
    }

    @Override
    public void uploadMultipleFile(List<Doc> files) {
        String newFileId;
        for(Doc file : files) {
            InputStream inputStream = new ByteArrayInputStream(file.getData());
            newFileId=fileService.createFile(inputStream,file.getFileName(),file.getContentType(),file.getMetaData());
            file.setFileId(newFileId);
        }
      docRepository.save(files);
    }

    @Override
    public List<Doc> findAll() {
        return (List<Doc>) docRepository.findAll();
    }

    /**
     *
     * @param file
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public Doc createDoc(MultipartFile file, String username, String password) throws Exception {
        Doc doc = new Doc();
        DBObject meteData = new BasicDBObject();
        meteData.put("user",username);
        meteData.put("pwd",password);
        doc.setContentType(file.getContentType());
        doc.setFileName(file.getOriginalFilename());
        doc.setModifiedBy(username);
        doc.setUploadDate(new Date(System.currentTimeMillis()));
        doc.setSize(file.getSize());
        doc.setData(file.getBytes());
        doc.setMetaData(meteData);

        return doc;
    }

    public Doc updateDoc(String docId,MultipartFile file,String username,String password) throws Exception {
        Doc doc = docRepository.findOneByFileId(docId);
        if(doc==null) {
            throw new Exception("the doc is not existed in db!");
        }
        DBObject meteData = new BasicDBObject();
        meteData.put("user",username);
        meteData.put("pwd",password);
        doc.setContentType(file.getContentType());
        doc.setFileName(file.getOriginalFilename());
        doc.setModifiedBy(username);
        doc.setUploadDate(new Date(System.currentTimeMillis()));
        doc.setSize(file.getSize());
        doc.setData(file.getBytes());
        doc.setMetaData(meteData);

        return  doc;
    }

    /**
     *
     * @param files
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
    public List<Doc> createMultipleDocs(List<MultipartFile> files, String username, String password) throws Exception {
        List<Doc> docs = new ArrayList<>();

        for(MultipartFile file : files) {
           Doc doc = new Doc();
            DBObject meteData = new BasicDBObject();
            meteData.put("user",username);
            meteData.put("pwd",password);
            doc.setContentType(file.getContentType());
            doc.setFileName(file.getOriginalFilename());
            doc.setModifiedBy(username);
            doc.setUploadDate(new Date(System.currentTimeMillis()));
            doc.setSize(file.getSize());
            doc.setData(file.getBytes());
            doc.setMetaData(meteData);
        }
        return docs;
    }

    /**
     *
     * @param doc
     * @param status
     * @param message
     * @return
     */
    public DocResponse mapSingleDocToResponse(Doc doc, HttpStatus status, String message) {
        DocResponse docResponse = new DocResponse(status.value(),message);
        docResponse.setFileCreated(doc.getUploadDate());
        docResponse.setFileModifiedBy(doc.getModifiedBy());
        docResponse.setFileName(doc.getFileName());
        docResponse.setFileSize(doc.getSize());
        docResponse.setFileType(doc.getContentType());
        docResponse.setFileId(doc.getFileId());
        return  docResponse;
    }

    /**
     *
     * @param docs
     * @param status
     * @param message
     * @return
     */
    public  List<DocResponse> mapMultipleDocsToResponse(List<Doc> docs, HttpStatus status, String message) {

        List<DocResponse> docResponses = new ArrayList<DocResponse>();

        for(Doc doc : docs) {
            DocResponse docResponse = new DocResponse(status.value(),message);
            docResponse.setFileCreated(doc.getUploadDate());
            docResponse.setFileModifiedBy(doc.getModifiedBy());
            docResponse.setFileName(doc.getFileName());
            docResponse.setFileSize(doc.getSize());
            docResponse.setFileType(doc.getContentType());
            docResponse.setFileId(doc.getFileId());
            docResponses.add(docResponse);
        }
        return  docResponses;
    }
}
