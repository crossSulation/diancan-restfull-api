package com.diancan.service.resto.doc;

import com.diancan.domain.resto.mongo.DocFile;
import com.diancan.respositorys.mongo.FileRepository;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class DocServiceImpl implements DocService {

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Autowired
    FileRepository fileRepository;

    @Override
    public DocFile findOneById(String id) {
        return fileRepository.findOneById(id);
    }

    @Override
    public void deleteOneById(String id) {
       fileRepository.delete(id);
       gridFsTemplate.delete(new Query(Criteria.where("_id").is(id)));
    }

    @Override
    public void deleteMultipleByGiveIds(List<String> ids) {
        fileRepository.deleteDocFilesByIdIn(ids);
        gridFsTemplate.delete(new Query(Criteria.where("_id").in(ids)));
    }

    @Override
    public void uploadOneFile(DocFile file) {
      fileRepository.save(file);
      InputStream inputStream = new ByteArrayInputStream(file.getData());
      gridFsTemplate.store(inputStream,file.getFileName(),file.getContentType(),file.getMetaData());
    }

    @Override
    public GridFSDBFile downloadOneFile(String id) {
        DocFile file =fileRepository.findOneById(id);
        if(file==null) {
            return null;
        }
       return gridFsTemplate.findOne(new Query(Criteria.where("_id").is(id)));
    }

    @Override
    public void uploadMultipleFile(List<DocFile> files) {
        for(DocFile file : files) {
            InputStream inputStream = new ByteArrayInputStream(file.getData());
            gridFsTemplate.store(inputStream,file.getFileName(),file.getContentType(),file.getMetaData());
        }
      fileRepository.save(files);
    }

    @Override
    public List<DocFile> findAll() {
        return (List<DocFile>) fileRepository.findAll();
    }
}
