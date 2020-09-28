/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.Proyecto.model;

/**
 *
 * @author diego
 */
public class ExceptionModel extends Exception {
    public ExceptionModel(String message) {
        super(message);
    }

    public ExceptionModel(String message, Throwable cause) {
        super(message, cause);
    }
}
