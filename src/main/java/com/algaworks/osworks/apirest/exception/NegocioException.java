package com.algaworks.osworks.apirest.exception;

//Classe pra tratativa de error de negócio (exceptions)
public class NegocioException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NegocioException(String message){
        super(message);
    }

}
