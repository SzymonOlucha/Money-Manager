package pl.sda.moneymanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MoneyGenericException extends RuntimeException {

    public MoneyGenericException() {
    }

    public MoneyGenericException(String message) {
        super(message);
    }

    public MoneyGenericException(String message, Throwable cause) {
        super(message, cause);
    }
}
