package com.diancan.service.resto.doc;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

@Service
@Transactional
public class FileService {

    @Autowired
    GridFsTemplate gridFsTemplate;

    public  String createFile(InputStream inputStream, String fileName, String fileContentType, DBObject metaData) {

        String newFileId ;
        newFileId= gridFsTemplate.store(inputStream,fileName,fileContentType,metaData).getId().toString();
        return  newFileId;
    }

    public GridFSDBFile getOneFileById(String fileId) {
        return  gridFsTemplate.findOne(new Query(Criteria.where("_id").is(fileId)));
    }

    public void deleteOneFileById(String fileId) {
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(fileId)));
    }

    public String updateFile(String fileId,InputStream inputStream, String fileName, String fileContentType, DBObject metaData) {
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(fileId)));
        String newFileId ;
        newFileId= gridFsTemplate.store(inputStream,fileName,fileContentType,metaData).getId().toString();
        return  newFileId;
    }

    public  void deleteMultipleFile(List<String> ids) {
        gridFsTemplate.delete(new Query(Criteria.where("_id").in(ids)));
    }
}
