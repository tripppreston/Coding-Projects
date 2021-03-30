/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.videogamewebapp.controller;

import java.text.MessageFormat;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 *
 * @author apprentice
 */
@Controller
public class ErrorController {

    public String customError(HttpServletRequest request, HttpServletRequest response, Model model) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        HttpStatus httpStatus = HttpStatus.valueOf((statusCode));

        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String exceptionMessage = httpStatus.getReasonPhrase();

        String requestUri = (String) request.getAttribute("javax.servlet.error.request.uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        
        String message = MessageFormat.format("{0} returned for {1}: {2}", statusCode, requestUri, exceptionMessage);
        
        model.addAttribute("errorMessage", message);
        return "customError";
    }
}
