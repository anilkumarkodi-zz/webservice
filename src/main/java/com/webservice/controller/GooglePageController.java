package com.webservice.controller;

import com.webservice.domain.GeoCoder;
import com.webservice.services.GoogleDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

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
    String get(@RequestParam(value = "fromAddress") String fromAddress, @RequestParam(value = "toAddress") String toAddress, @RequestParam(value = "travelMode") String travelMode) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        String distance;
            if (service.isLocationPresent(fromAddress, toAddress, travelMode)) {
            distance = service.getDistance(fromAddress, toAddress, travelMode);
        } else {
            GeoCoder geoCoder = new GeoCoder();
            distance = geoCoder.calculateDistance(fromAddress.replaceAll(" ", "+"), toAddress.replaceAll(" ", "+"), travelMode);
            service.save(fromAddress, toAddress, distance, travelMode);
        }
        return distance;
    }
}
