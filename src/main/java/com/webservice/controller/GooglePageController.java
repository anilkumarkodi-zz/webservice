package com.webservice.controller;

import com.webservice.services.GoogleDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GooglePageController {

    @Autowired
    private GoogleDBService service;

    @RequestMapping(value = "/googleDistance", method = RequestMethod.GET)
    public ModelAndView load() {
        return new ModelAndView("googleDistance");
    }

    @RequestMapping(value = "/findDistance", method = RequestMethod.GET)
    public
    @ResponseBody
    String get(@RequestParam(value = "fromAddress") String fromAddress, @RequestParam(value = "toAddress") String toAddress) {
        String distance = "Not Found";
        if (service.isLocationPresent(fromAddress, toAddress)) {
            service.getDistance(fromAddress, toAddress);
            distance = service.getDistance(fromAddress, toAddress);
        }
        return distance;
    }

    @RequestMapping(value = "/saveDistance", method = RequestMethod.GET)
    public
    @ResponseBody
    void save(@RequestParam(value = "from_address") String fromAddress, @RequestParam(value = "to_address") String toAddress, @RequestParam(value = "distance") String distance) {
        service.save(fromAddress, toAddress, distance);
    }
}
