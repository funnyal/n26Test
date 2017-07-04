package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NO_CONTENT)
public class OlderTransactionException extends RuntimeException {

	public OlderTransactionException() {
		super();
	}

}
