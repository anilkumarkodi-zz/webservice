package com.webservice.domain;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        GeoCoder geoCoder=new GeoCoder();
        System.out.println(geoCoder.calculateDistance("chennai", "bangalore", "driving"));
    }
}
