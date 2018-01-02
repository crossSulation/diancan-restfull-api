package com.diancan.service.resto.doc;

import com.diancan.domain.resto.mongo.DocFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class DocServiceImpl implements DocService {

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Override
    public DocFile findOneById(String id) {
        return null;
    }

    @Override
    public void deleteOneById(String id) {

    }

    @Override
    public void deleteMultipleByGiveIds(List<String> ids) {

    }

    @Override
    public void uploadOneFile(DocFile file) {

    }

    @Override
    public Stream downloadOneFile(String id) {
        return null;
    }

    @Override
    public List<DocFile> uploadMultipleFile(List<DocFile> files) {
        return null;
    }
}
