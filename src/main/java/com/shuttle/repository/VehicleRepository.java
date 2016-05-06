/**
 * Created Date: 5 May 2016
 * Last Modified Date: 5 May 2016
 */
package com.shuttle.repository;

import com.shuttle.bean.VehicleBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author baldeep
 */
@Repository
public interface VehicleRepository extends MongoRepository<VehicleBean,String>{
    
}
