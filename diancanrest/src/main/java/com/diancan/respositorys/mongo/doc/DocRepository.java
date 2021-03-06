package com.diancan.respositorys.mongo.doc;

import com.diancan.domain.resto.mongo.Doc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface DocRepository extends MongoRepository<Doc,String> {

    @Query(value = "{'fileId' : {'$eq' : ?0}}")
    Doc findOneByFileId(String fileId);

    @DeleteQuery(value = "{'_id': {'$in' : ?0}}")
    void deleteMutipleByGivenIds(List<String> ids);

    @Query(value = "{$or: {filename: {$regex: ?0},{modify: {$regex: ?1}}}}")
    Page<Doc> findAllBy(String filename , String modify, Pageable pageable);

    void deleteDocByFileId(String fileId);
}

