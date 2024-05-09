package org.example.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    // method
    String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
