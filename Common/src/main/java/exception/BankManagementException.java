package exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Builder
@Component
@Data
public class BankManagementException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private HttpStatus errorCode;
    private String errorMessage;

    public BankManagementException(String errorMessage) {
        super();
        this.errorCode = HttpStatus.NOT_FOUND;
        this.errorMessage = errorMessage;
    }

    public BankManagementException(HttpStatus errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
