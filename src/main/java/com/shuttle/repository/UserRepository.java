/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.repository;

import com.shuttle.bean.UserBean;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserBean,String> {
     List<UserBean> findByUserRole(String role);
     UserBean findByUserEmail(String userEmail);
     UserBean findTopByOrderByUserIdDesc();
}
