package com.diancan.service.resto.doc;

import com.diancan.domain.resto.mongo.DocFile;
import com.mongodb.gridfs.GridFSDBFile;

import java.util.List;
import java.util.stream.Stream;

public interface DocService {

    public DocFile findOneById(String id);

    public List<DocFile> findAll();
    public void deleteOneById(String id);

    public  void deleteMultipleByGiveIds(List<String> ids);

    public  void uploadOneFile(DocFile file);

    public GridFSDBFile downloadOneFile(String id);

    public void uploadMultipleFile(List<DocFile> files);

}
