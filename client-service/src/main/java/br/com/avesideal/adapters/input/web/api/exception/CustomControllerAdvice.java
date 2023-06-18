package br.com.avesideal.adapters.input.web.api.exception;

import br.com.avesideal.adapters.input.web.api.exception.errors.ApiErrorsResponse;
import br.com.avesideal.adapters.input.web.api.exception.errors.ClientNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomControllerAdvice {

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ApiErrorsResponse> handleClientNotFoundException(ClientNotFoundException clientNotFoundException
                                                                           , WebRequest webRequest){
        var dataError = ApiErrorsResponse.DataMessageError
                                                        .builder()
                                                        .description(clientNotFoundException.getLocalizedMessage())
                                                        .localDateTime(LocalDateTime.now())
                                                        .message("Client not Found")
                                                        .statusCode(HttpStatus.NOT_FOUND.value())
                                                        .build();

        var apiErrors = ApiErrorsResponse.builder()
                                                         .dataMessageError(dataError)
                                                         .status(HttpStatus.NOT_FOUND)
                                                         .build();

        return new ResponseEntity<ApiErrorsResponse>(apiErrors,HttpStatus.NOT_FOUND);

    }
}
