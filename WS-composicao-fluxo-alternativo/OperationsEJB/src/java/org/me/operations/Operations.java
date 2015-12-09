/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.operations;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author monkey_001
 */
@WebService(serviceName = "Operations")
@Stateless()
public class Operations {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "add")
    public Integer add(@WebParam(name = "num1") Integer num1, @WebParam(name = "num2") Integer num2) {
        return num1 + num2;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "mult")
    public Integer mult(@WebParam(name = "num1") Integer num1, @WebParam(name = "num2") Integer num2) {
        return num1 * num2;
    }
}
