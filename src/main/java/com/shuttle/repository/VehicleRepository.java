/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
