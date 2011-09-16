<%-- 
    Document   : home
    Created on : Sep 13, 2011, 3:06:40 PM
    Author     : aungta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
    <f:view>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>PayPal payflow</title>
            <style>
            	body {
            		font-size: 10px;
            		font-family: verdana;
            	}
            </style>
        </head>
        <body>
            <h:form>
                <h:commandButton value="DoDirectPayment" action="#{paymentMB.makePayment()}"></h:commandButton>
            </h:form>
        </body>
    </f:view>
</html>
