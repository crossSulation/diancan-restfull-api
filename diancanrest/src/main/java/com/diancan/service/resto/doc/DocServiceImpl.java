package com.diancan.service.resto.doc;

import com.diancan.domain.resto.mongo.DocFile;
import com.diancan.respositorys.mongo.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;

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
