/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author diego
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception  {
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
    
}
    
