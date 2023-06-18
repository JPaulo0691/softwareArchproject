package br.com.avesideal.adapters.input.web.api.exception.errors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorsResponse {

    private HttpStatus status;
    private DataMessageError dataMessageError;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DataMessageError{

        private int statusCode;
        private String message;
        private LocalDateTime localDateTime;
        private String description;
    }
}
