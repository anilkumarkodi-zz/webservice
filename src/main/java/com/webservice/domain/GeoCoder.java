package com.webservice.domain;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeoCoder {

    public String calculateDistance(String addressFrom, String addressTo, String travelMode) throws IOException, ParserConfigurationException, SAXException, XPathExpressionException {
        String jsonString = getJsonString(addressFrom, addressTo, travelMode);
        return getDistance(jsonString);
    }

    public String getJsonString(String addressFrom, String addressTo, String travelMode) throws IOException {
        String urlString = "http://maps.googleapis.com/maps/api/directions/json?origin=" + addressFrom + "&destination=" + addressTo + "&sensor=false&mode=" + travelMode;
        URL googleUrl = new URL(urlString);
        HttpURLConnection googleUrlConnection = (HttpURLConnection) googleUrl.openConnection();
        googleUrlConnection.connect();
        String outputResult = getOutputString(googleUrlConnection);
        googleUrlConnection.disconnect();
        return outputResult;
    }

    String getOutputString(HttpURLConnection googleUrlConnection) throws IOException {
        OutputStream output = new OutputStream() {
            private StringBuilder string = new StringBuilder();

            @Override
            public void write(int b) throws IOException {
                this.string.append((char) b);
            }

            @Override
            public String toString() {
                return this.string.toString();
            }
        };
        byte buf[] = new byte[1024];
        int len;
        while ((len = googleUrlConnection.getInputStream().read(buf)) > 0) {
            output.write(buf, 0, len);
        }
        output.close();
        googleUrlConnection.getInputStream().close();
        return output.toString();
    }

    private String getDistance(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readValue(jsonString, JsonNode.class);
        return String.valueOf(rootNode.get("routes").get(0).get("legs").get(0).get("distance").get("text")).replaceAll("\"", "");
    }


//    private Document getDocument(String outputResult) throws ParserConfigurationException, IOException, SAXException {
//        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//        InputSource inputSource = new InputSource();
//
//        inputSource.setCharacterStream(new StringReader(outputResult));
//        return documentBuilder.parse(inputSource);
//    }

//    private String getDistance(Document doc) throws XPathExpressionException {
//        XPath xPath = XPathFactory.newInstance().newXPath();
//        XPathExpression xPathExpression = xPath.compile("//DirectionsResponse/route/leg/distance/text/text()");
//        Object evaluate = xPathExpression.evaluate(doc, XPathConstants.STRING);
//        return evaluate.toString();
//    }
}
