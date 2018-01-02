package com.diancan.respositorys.mongo;

import com.diancan.domain.resto.mongo.DocFile;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FileRepository extends PagingAndSortingRepository<DocFile,ObjectId> {

    DocFile findOneById(ObjectId objectId);

}
