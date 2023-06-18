package br.com.avesideal.adapters.input.web.api.exception.errors;

public class ClientNotFoundException extends RuntimeException{

    public ClientNotFoundException(Long id){
        super(String.format("O cliente de nr.%d não existe", id));
    }
}
