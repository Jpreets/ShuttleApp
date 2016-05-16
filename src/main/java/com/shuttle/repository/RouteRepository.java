
package com.shuttle.repository;

import com.shuttle.bean.RouteBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author baldeep
 */
@Repository
public interface RouteRepository extends MongoRepository<RouteBean,String>{
    
}
