package com.diancan.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface RestoBasicInfoRepository extends MongoRepository<RestoBasicInfo,Integer>{
}
