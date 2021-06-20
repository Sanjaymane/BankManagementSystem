package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseVO <T>{

    private boolean success;
    private Errors error;
    private T data;
    private String additionalMessage;

    @Data
    @Builder
    public static class Errors {
        private HttpStatus errorCode;
        private String errorMessage;
    }
}
