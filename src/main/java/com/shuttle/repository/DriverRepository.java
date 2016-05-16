
package com.shuttle.repository;

import com.shuttle.bean.DriverBean;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author baldeep
 */
public interface DriverRepository extends MongoRepository<DriverBean,String> {
    
}
