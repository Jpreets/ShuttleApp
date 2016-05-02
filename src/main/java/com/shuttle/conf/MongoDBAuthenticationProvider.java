/**
 * Created Date: 28 April 2016
 * Last Modified Date: 28 April 2016
 */
package com.shuttle.conf;

/**
 *
 * @author Baldeep Singh Kwatra
 */
import com.shuttle.bean.UserBean;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import com.shuttle.constants.ShuttleConstants;

@Component("authenticationProvider")
public class MongoDBAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private MongoOperations mongoOperation;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        try {
            String password = (String) authentication.getCredentials();

            Query searchUserQuery = new Query();
            searchUserQuery.addCriteria(Criteria.where("userEmail").is(username));

            password = BCrypt.hashpw(password, ShuttleConstants.SALT);

            searchUserQuery.addCriteria(Criteria.where("userPassword").is(password));

            // find the saved user again.
            UserBean user = mongoOperation.findOne(searchUserQuery, UserBean.class);

            if (user != null) {
                final List<GrantedAuthority> auths;
                if (!user.getUserRole().isEmpty()) {
                    auths = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getUserRole());
                } else {
                    auths = AuthorityUtils.NO_AUTHORITIES;
                }
                return new User(user.getUserEmail(), user.getUserPassword(), auths);
            }

        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }

        throw new InternalAuthenticationServiceException(
                "UserDetailsService returned null, which is an interface contract violation");
    }
}
