///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.shuttle.conf;
//
//import com.shuttle.bean.UserBean;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoOperations;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Query;
//import org.springframework.security.authentication.InternalAuthenticationServiceException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
///**
// *
// * @author jaspreetsingh
// */
//@Component
//public class MongoUserDetailsService implements UserDetailsService{
//
//   @Autowired
//    private MongoOperations mongoOperation;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        
//        try {
////            String password = (String) authentication.getCredentials();
//
//            Query searchUserQuery = new Query();
//            searchUserQuery.addCriteria(Criteria.where("userEmail").is(username));
////            searchUserQuery.addCriteria(Criteria.where("userPassword").is(password));
//
//            // find the saved user again.
//            UserBean user = mongoOperation.findOne(searchUserQuery, UserBean.class);
//
//            if (user != null) {
//                final List<GrantedAuthority> auths;
//                if (!user.getUserRole().isEmpty()) {
//                    auths = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getUserRole());
//                } else {
//                    auths = AuthorityUtils.NO_AUTHORITIES;
//                }
//                System.out.println("-----------------"+user.getUserRole());
//                System.out.println("-----------------"+auths);
//                return new User(user.getUserEmail(), user.getUserPassword(), auths);
//            }
//
//        } catch (Exception repositoryProblem) {
//            throw new UsernameNotFoundException(repositoryProblem.getMessage(), repositoryProblem);
//        }
//
//        throw new UsernameNotFoundException(
//                "UserDetailsService returned null, which is an interface contract violation");
//       
//    }
//    
//}
