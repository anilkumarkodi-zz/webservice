package com.webservice.persistence;

import java.util.Map;

public interface GoogleService {
    public void saveDistance(Map<String, String> map);
    String getDistance(Map<String, String> map);
}
