package br.ada.treinamento.exception;

public class InvalidStateException extends RuntimeException {
    public InvalidStateException(String msg){
        super(msg);
    }
}
