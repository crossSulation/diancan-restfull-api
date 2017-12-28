package com.diancan.respositorys.mongo;

import com.diancan.domain.resto.mongo.ImageFile;
import org.bson.types.ObjectId;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FileRepository extends PagingAndSortingRepository<ImageFile,ObjectId> {

}
