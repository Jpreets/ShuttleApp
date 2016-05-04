/**
 * Created Date: 4 April 2016
 * Last Modified Date: 2 May 2016
 */
package com.shuttle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttle.bean.UserBean;
import com.shuttle.service.Notification;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import com.shuttle.repository.UserRepository;
import com.shuttle.util.GeneratePassword;
import java.util.List;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import com.shuttle.constants.ShuttleConstants;

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Notification notification;

    /**
     *
     * @param user
     * @param result
     * @param model
     * @return
     */
    @RequestMapping(value = ShuttleConstants.USER_REGISTRATION, method = RequestMethod.POST)
    public ModelAndView index(@ModelAttribute("user") @Valid UserBean user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {

            //Create a list of errors.
            List<FieldError> errors = result.getFieldErrors();
            StringBuffer errorMessage = new StringBuffer();
            //create error message.
            for (FieldError error : errors) {

                errorMessage.append(error.getDefaultMessage()).append("<br>");
            }
            return new ModelAndView("redirect:/index.html?errorMsg=" + errorMessage);
        } else {
            user.setUserEmail(user.getUserEmail().toLowerCase());
            if (userRepository.findByUserEmail(user.getUserEmail()) == null) {

                user.setUserName(user.getUserName().toUpperCase());
                user.setUserPassword(BCrypt.hashpw(user.getUserPassword(),
                        ShuttleConstants.SALT));//hash user password before storing

                UserBean lastUser = userRepository.findTopByOrderByUserIdDesc();
                if(lastUser!=null){
                user.setUserId((lastUser.getUserId()) + 1);}
                else{user.setUserId(1);}
                if (userRepository.save(user) != null) {

                    notification.sendWelcomeMail(user);//trigger welcome mail
                    return new ModelAndView("redirect:/index.html?login");
                } else {

                    return new ModelAndView("redirect:/index.html?errorMsg=Registration could not be completed");
                }
            }
            return new ModelAndView("redirect:/index.html?errorMsg=User already exists with this Email ID");
        }
    }

    /**
     *
     * @param request
     * @return
     */
    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin/dashboard.html";
        }
        return "redirect:/driver/index.html";
    }

    /**
     *
     *
     * @param userEmail
     * @return
     */
    @RequestMapping(value = ShuttleConstants.USER_FORGOT_PASSWORD, method = RequestMethod.POST)
    public ModelAndView forgotPassword(String userEmail) {

        //Find user by email
        UserBean user = userRepository.findByUserEmail(userEmail.toLowerCase());
        if (user != null) {
            String temporaryPassword = GeneratePassword.randomPassword();//Generate Random Password
            user.setUserChangePassword(temporaryPassword);
            userRepository.save(user);
            notification.sendForgotPasswordEmail(user, temporaryPassword);//Trigger forgot Password Email
            return new ModelAndView("redirect:/index.html?errorMsg=Please check your Email in order to reset your password");
        }
        return new ModelAndView("redirect:/index.html?errorMsg=No account exists with this Email ID.");
    }

    /**
     *
     * @param email
     * @param userPassword password to be updated
     * @param key unique code sent at the time of Password Reset Mail
     * @return
     */
    @RequestMapping(value = ShuttleConstants.USER_CHANGE_PASSWORD, method = RequestMethod.POST)
    public ModelAndView changePasswordSubmit(String email, String userPassword, String key) {
        UserBean user = userRepository.findByUserEmail(email.toLowerCase());
        if (user.getUserChangePassword().equals(key)) {
            String temporaryPassword = GeneratePassword.randomPassword();
            user.setUserChangePassword(temporaryPassword);
            user.setUserPassword(BCrypt.hashpw(userPassword, ShuttleConstants.SALT));
            userRepository.save(user);
            return new ModelAndView("redirect:/index.html?login");
        }
        return new ModelAndView("redirect:/index.html?errorMsg=The link has expired");
    }
}
