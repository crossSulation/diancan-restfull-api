package com.diancan.service.resto.doc;

import com.diancan.domain.resto.mongo.Doc;
import com.mongodb.gridfs.GridFSDBFile;

import java.util.List;

public interface DocService {

    public Doc findOneById(String id);

    public List<Doc> findAll();

    public void deleteOneById(String id);

    public  void deleteMultipleByGiveIds(List<String> ids);

    public  void uploadOneFile(Doc file);

    public GridFSDBFile downloadOneFile(String id);

    public void uploadMultipleFile(List<Doc> files);

}
