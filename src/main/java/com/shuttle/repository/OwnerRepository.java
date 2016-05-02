/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shuttle.repository;

import com.shuttle.bean.OwnerBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends MongoRepository<OwnerBean,String>{

     OwnerBean findByOwnerEmail(String ownerEmail);
}