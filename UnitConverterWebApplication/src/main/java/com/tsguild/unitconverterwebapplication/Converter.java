/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.unitconverterwebapplication;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author apprentice
 */
@WebServlet(name = "Converter", urlPatterns = {"/Converter"})
public class Converter extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Converter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Converter at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double temperature = 0;
        double currency = 0;
        double length = 0;
        double lengthInMeters = 0;
        
        String lastForm = request.getParameter("button");
        
        String modal = "";
        
        String startingTemperature = request.getParameter("startTemp");
        double startTemp = Double.parseDouble(startingTemperature);
        String startingCurrency = request.getParameter("startCurrency");
        double startCurrency = Double.parseDouble(startingCurrency);
        String startingLength = request.getParameter("startLength");
        double startLength = Double.parseDouble(startingLength);
        
        String tempTypeStart = request.getParameter("tempTypeStart");
        String tempTypeDesired = request.getParameter("tempTypeDesired");
        String currencyTypeStart = request.getParameter("currencyTypeStart");
        String currencyTypeDesired = request.getParameter("currencyTypeDesired");
        String lengthTypeStart = request.getParameter("lengthTypeStart");
        String lengthTypeDesired = request.getParameter("lengthTypeDesired");
        
        switch (request.getParameter("tempTypeStart")) {
            case "celsius": //(C * 9/5) + 32
                switch (tempTypeDesired) {
                    case "celsius":
                        temperature = startTemp;
                        break;
                    case "fahrenheit":
                        temperature = (startTemp * (9 / 5)) + 32;
                        break;
                    case "kelvin"://C + 273.15
                        temperature = startTemp + 273.15;
                        break;
                    default:
                }
                break;
            case "fahrenheit":
                switch (tempTypeDesired) {
                    case "celsius":
                        temperature = (startTemp - 32) * (5 / 9);
                        break;
                    case "fahrenheit":
                        temperature = startTemp;
                        break;
                    case "kelvin"://(F - 32) * 5/9 + 273.15
                        temperature = (startTemp - 32) * (5 / 9) + 273.15;
                        break;
                    default:
                }
                break;
            case "kelvin":
                switch (tempTypeDesired) {
                    case "celsius"://K - 273.15
                        temperature = startTemp - 273.15;
                        break;
                    case "fahrenheit"://(K - 273.15) * 9/5 + 32
                        temperature = (startTemp - 273.15) * (9 / 5) + 32;
                        break;
                    case "kelvin":
                        temperature = startTemp;
                        break;
                    default:
                }
                break;
            default:
        }
        
        switch (currencyTypeStart) {
            case "USD":
                switch (currencyTypeDesired) {
                    case "USD":
                        currency = startCurrency;
                        break;
                    case "EUR":
                        currency = startCurrency * .92075;
                        break;
                    case "GBP":
                        currency = startCurrency * .82480;
                        break;
                    case "CAD":
                        currency = startCurrency * 1.33357;
                        break;
                    default:
                }
                break;
            case "EUR":
                switch (currencyTypeDesired) {
                    case "USD":
                        currency = startCurrency * 1.08607;
                        break;
                    case "EUR":
                        currency = startCurrency;
                        break;
                    case "GBP":
                        currency = startCurrency * .89580;
                        break;
                    case "CAD":
                        currency = startCurrency * 1.44803;
                        break;
                    default:
                }
                break;
            case "GBP":
                switch (currencyTypeDesired) {
                    case "USD":
                        currency = startCurrency * 1.21241;
                        break;
                    case "EUR":
                        currency = startCurrency * 1.11633;
                        break;
                    case "GBP":
                        currency = startCurrency;
                        break;
                    case "CAD":
                        currency = startCurrency * 1.62529;
                        break;
                    default:
                }
                break;
            case "CAD":
                switch (currencyTypeDesired) {
                    case "USD":
                        currency = startCurrency * .74968;
                        break;
                    case "EUR":
                        currency = startCurrency * .69051;
                        break;
                    case "GBP":
                        currency = startCurrency * .61901;
                        break;
                    case "CAD":
                        currency = startCurrency;
                        break;
                    default:
                }
                break;
            default:
        }
        switch (lengthTypeStart) {
            case "millimeter":
                lengthInMeters = startLength * 1000;
                break;
            case "centimeter":
                lengthInMeters = startLength * 100;
                break;
            case "meter":
                lengthInMeters = startLength;
                break;
            case "kilometer":
                lengthInMeters = startLength * .001;
                break;
            default:
        }
        switch (lengthTypeDesired) {
            case "inch":
                length = lengthInMeters * 39.3701;
                break;
            case "foot":
                length = lengthInMeters * 3.280084;
                break;
            case "yard":
                length = lengthInMeters * 1.09361;
                break;
            case "mile":
                length = lengthInMeters * .000621371;
                break;
        }
        if ("tempSubmitButton".equals(lastForm)) {
            modal = "temperatureModal";
        } else if ("currencySubmitButton".equals(lastForm)) {
            modal = "currencyModal";
        } else if ("lengthSubmitButton".equals(lastForm)) {
            modal = "lengthModal";
        }
        
        request.setAttribute("modal", modal);
        request.setAttribute("currency", currency);
        request.setAttribute("length", length);
        request.setAttribute("temperature", temperature);
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
