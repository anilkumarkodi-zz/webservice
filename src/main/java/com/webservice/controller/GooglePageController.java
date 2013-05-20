package com.webservice.controller;

import com.webservice.domain.GeoCoder;
import com.webservice.persistence.GoogleService;
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
import java.util.HashMap;
import java.util.Map;

@Controller
public class GooglePageController {

    private GoogleService googleService;

    @Autowired
    public void setGoogleService(GoogleService googleService) {
        this.googleService = googleService;
    }


//    private GoogleDBService service;

    @RequestMapping(value = "/googleDistance", method = RequestMethod.GET)
    public ModelAndView load() {
        return new ModelAndView("googleDistance");
    }

    @RequestMapping(value = "/findDistance", method = RequestMethod.GET)
    public
    @ResponseBody
    String get(@RequestParam(value = "fromAddress") String fromAddress, @RequestParam(value = "toAddress") String toAddress, @RequestParam(value = "travelMode") String travelMode) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("fromAddress", fromAddress);
        map.put("toAddress", toAddress);
        map.put("travelMode", travelMode);
        String distance = googleService.getDistance(map);
        if (distance == null) {
            GeoCoder geoCoder = new GeoCoder();
            distance = geoCoder.calculateDistance(fromAddress.replaceAll(" ", "+"), toAddress.replaceAll(" ", "+"), travelMode);
            map.put("distance", distance);
            googleService.saveDistance(map);
        }
        return distance;
    }
}
