package com.diancan.respositorys.mongo;

import com.diancan.domain.resto.mongo.DocFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FileRepository extends PagingAndSortingRepository<DocFile,String> {

    @Query(value = "{$eq: {'_id' : ?0}}")
    DocFile findOneById(String id);

    @DeleteQuery(value = "{$in: {'_id' : ?0}}")
    void deleteMutipleByGivenIds(List<String> ids);

    @Query(value = "{filename: {$regex: ?0}}")
    Page<DocFile> findAllBy(String filename ,Pageable pageable);
}
