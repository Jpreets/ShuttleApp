/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.repository;

import com.shuttle.bean.OwnerBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends MongoRepository<OwnerBean,String>{

     OwnerBean findByOwnerEmail(String ownerEmail);
}
