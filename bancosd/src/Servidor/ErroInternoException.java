package Servidor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Dacio
 */
public class ErroInternoException extends Exception {
    
    public ErroInternoException(String message) {
        super(message);
    }

    public ErroInternoException(Throwable cause) {
        super(cause);
    }
    
}
