package com.diancan.respositorys.mongo;

import com.diancan.domain.resto.mongo.DocFile;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface FileRepository extends PagingAndSortingRepository<DocFile,String> {

    @Query("{$eq:{'_id':?0}}")
    DocFile findOneById(String id);

    @DeleteQuery("{$in:{'_id':?0}}")
    void deleteDocFilesByIdIn(List<String> ids);


}
