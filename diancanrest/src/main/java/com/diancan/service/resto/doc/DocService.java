package com.diancan.service.resto.doc;

import com.diancan.domain.resto.mongo.DocFile;

import java.util.List;
import java.util.stream.Stream;

public interface DocService {

    public DocFile findOneById(String id);

    public void deleteOneById(String id);

    public  void deleteMultipleByGiveIds(List<String> ids);

    public  void uploadOneFile(DocFile file);

    public Stream downloadOneFile(String id);

    public List<DocFile> uploadMultipleFile(List<DocFile> files);

}
