package com.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

@Controller
public class HomeController {
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView setup() throws XPathExpressionException {

//        XPath xpath = XPathFactory.newInstance().newXPath();
//        String expression = "//GeocodeResponse/result/address_component[type=\"postal_code\"]/long_name/text()";
//        InputSource inputSource = new InputSource("https://maps.googleapis.com/maps/api/geocode/xml?latlng="+VARIABLECONTAININGLATITUDE+","+VARIABLECONTAININGLONGITUDE+"&sensor=true");
//        String zipcode = (String) xpath.evaluate(expression, inputSource, XPathConstants.STRING);

        return new ModelAndView("home");

    }
}