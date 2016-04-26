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
import java.util.List;
import javax.validation.Valid;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
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
            user.setUserEmail(user.getUserName().toUpperCase());
            user.setUserPassword(BCrypt.hashpw(user.getUserPassword(), ControllerConstants.SALT));
            if (userRepository.save(user) != null) {
                notification.sendWelcomeMail(user);
                return new ModelAndView("redirect:/index.html?login");
            } else {
                return new ModelAndView("redirect:/index.html", "errors", "Could not save");
            }
        }
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/admin/index.html";
        }
        return "redirect:/driver/index.html";
    }

    @RequestMapping("/errorsPage")
    public String errors() {
        return "/errors.jsp";
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    @ResponseBody
    public String forgotPassword(String userEmail) {
        System.out.println("Email from form:" + userEmail);
        System.out.println("User Object" + userRepository.findByUserEmail(userEmail.toLowerCase()));
//        if (userRepository.save(user) != null) {
//            notification.sendWelcomeMail(user);
//            return "redirect:/index.html?login";
//        } else {
//            return "redirect:/index.html";//error message to be sent
//        }
        return "hello";
    }

}
