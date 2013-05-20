package com.webservice.controller;

import com.webservice.domain.User;
import com.webservice.persistence.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.xpath.XPathExpressionException;

@Controller
public class HomeController {

    private UserService userService = null;

    @Autowired
    public void setUserService(UserService googleService) {
        this.userService = googleService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView setup() throws XPathExpressionException {
        return new ModelAndView("registration");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute(value = "user") User user) {
        ModelAndView mv = new ModelAndView("registration");
        userService.saveUser(user);
        mv.addObject("users", user.getAge());
        return mv;
    }
}