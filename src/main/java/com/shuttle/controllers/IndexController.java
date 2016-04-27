package com.shuttle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shuttle.bean.UserBean;
import com.shuttle.constants.ControllerConstants;
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

@Controller
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Notification notification;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView index(@ModelAttribute("user") @Valid UserBean user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {

            List<FieldError> errors = result.getFieldErrors();
            StringBuffer errorMessage = new StringBuffer();

            for (FieldError error : errors) {

                errorMessage.append(error.getDefaultMessage()).append("<br>");
            }
            return new ModelAndView("redirect:/index.html?errorMsg=" + errorMessage);
        } else {
            user.setUserEmail(user.getUserEmail().toLowerCase());
            if (userRepository.findByUserEmail(user.getUserEmail()) == null) {
                
                user.setUserName(user.getUserName().toUpperCase());
                user.setUserPassword(BCrypt.hashpw(user.getUserPassword(), ControllerConstants.SALT));
                
                if (userRepository.save(user) != null) {
                    
                    notification.sendWelcomeMail(user);
                    return new ModelAndView("redirect:/index.html?login");
                } else {
                    
                    return new ModelAndView("redirect:/index.html?errorMsg=Registration could not be completed");
                }
            }
            return new ModelAndView("redirect:/index.html?errorMsg=User already exists with this Email ID");
        }
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin/index.html";
        }
        return "redirect:/driver/index.html";
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)

    public ModelAndView forgotPassword(String userEmail) {
        System.out.println("Forgot Password" + userEmail);
        UserBean user = userRepository.findByUserEmail(userEmail.toLowerCase());
        if (user != null) {
            String temporaryPassword = GeneratePassword.randomPassword();
            user.setUserChangePassword(temporaryPassword);
            userRepository.save(user);
            notification.sendForgotPasswordEmail(user, temporaryPassword);
        }
        return new ModelAndView("redirect:/index.html?errorMsg=Please check your Email in order to reset your password");
    }

    @RequestMapping(value = "/ChangePasswordSubmit", method = RequestMethod.POST)
    public ModelAndView changePasswordSubmit(String email, String userPassword, String key) {
        UserBean user = userRepository.findByUserEmail(email.toLowerCase());
        if (user.getUserChangePassword().equals(key)) {
            String temporaryPassword = GeneratePassword.randomPassword();
            user.setUserChangePassword(temporaryPassword);
            user.setUserPassword(BCrypt.hashpw(userPassword, ControllerConstants.SALT));
            userRepository.save(user);
            return new ModelAndView("redirect:/index.html?login");
        }
        return new ModelAndView("redirect:/index.html?errorMsg=The link has expired");
    }
}
