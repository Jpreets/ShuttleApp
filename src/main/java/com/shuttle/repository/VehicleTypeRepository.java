/**
 * Created Date: 06 May 2016
 * Last Modified Date: 06 May 2016
 */
package com.shuttle.repository;

import com.shuttle.bean.VehicleTypeBean;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author baldeep
 */
public interface VehicleTypeRepository extends MongoRepository<VehicleTypeBean,String>{
    
    
}
