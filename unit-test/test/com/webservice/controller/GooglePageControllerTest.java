package com.webservice.controller;

import org.hamcrest.core.IsEqual;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import static org.junit.Assert.assertThat;

public class GooglePageControllerTest {
    private MockHttpServletRequest mockHttpServletRequest;
    private MockHttpServletResponse mockHttpServletResponse;
    private AnnotationMethodHandlerAdapter handlerAdapter;
    private GooglePageController googlePageController;

    @Before
    public void setup(){
        mockHttpServletRequest = new MockHttpServletRequest();
        mockHttpServletResponse = new MockHttpServletResponse();
        handlerAdapter = new AnnotationMethodHandlerAdapter();
        googlePageController=new GooglePageController();
        mockHttpServletRequest.setRequestURI("/findDistance");
        mockHttpServletRequest.setMethod("GET");
    }
    @Test
    public void shouldReturnGoogleDistancePage() throws Exception {
        mockHttpServletRequest.setParameter("fromAddress","chennai");
        mockHttpServletRequest.setParameter("toAddress","bangalore");
        ModelAndView modelAndView = handlerAdapter.handle(mockHttpServletRequest, mockHttpServletResponse, googlePageController);
        assertThat(modelAndView.getViewName(), IsEqual.equalTo("googleDistance"));
        assertThat((String)modelAndView.getModel().get("distance"), IsEqual.equalTo("10000"));
    }
}
