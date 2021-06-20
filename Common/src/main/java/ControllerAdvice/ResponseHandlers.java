package ControllerAdvice;

import exception.BankManagementException;
import lombok.NoArgsConstructor;
import model.ResponseVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor
public class ResponseHandlers<T> {

    public <R> ResponseEntity<R> defaultResponse(T data){
        ResponseVO<T> responseModel = (ResponseVO<T>) ResponseVO.builder()
                .success(true)
                .data(data)
                .build();
        return new ResponseEntity<R>((R) responseModel, HttpStatus.OK);
    }

    public <R> ResponseEntity<R> defaultResponse(T data, String message){
        ResponseVO<T> responseModel = (ResponseVO<T>) ResponseVO.builder()
                .success(true)
                .additionalMessage(message)
                .data(data)
                .build();
        return new ResponseEntity<R>((R) responseModel, HttpStatus.OK);
    }

    public <R> ResponseEntity<R> defaultResponse(T data, String message, HttpStatus status){
        ResponseVO<T> responseModel = (ResponseVO<T>) ResponseVO.builder()
                .success(true)
                .additionalMessage(message)
                .data(data)
                .build();
        return new ResponseEntity<R>((R) responseModel, status);
    }

    public <R> ResponseEntity<R> defaultResponse(String message, HttpStatus status){
        ResponseVO<T> responseModel = (ResponseVO<T>) ResponseVO.builder()
                .success(true)
                .additionalMessage(message)
                .build();
        return new ResponseEntity<R>((R) responseModel, status);
    }

    @SuppressWarnings("unchecked")
    public <R> ResponseEntity<ResponseVO<R>> handleExceptions(BankManagementException ex) {
        ResponseVO<T> responseModel = (ResponseVO<T>) ResponseVO.builder()
                .success(false)
                .error(
                ResponseVO.Errors.builder()
                                .errorCode(ex.getErrorCode())
                                .errorMessage(ex.getErrorMessage())
                                .build()
                )
                .build();
        return new ResponseEntity<ResponseVO<R>>((ResponseVO<R>) responseModel, ex.getErrorCode());
    }
}
