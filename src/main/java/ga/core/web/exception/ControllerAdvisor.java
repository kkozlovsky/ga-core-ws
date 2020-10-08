package ga.core.web.exception;

import ga.core.web.dto.ErrorCode;
import ga.core.web.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

	private static final ResponseDto CLIENT_EXISTS_RESPONSE = new ResponseDto(ErrorCode.CLIENT_EXISTS.getCode());
	private static final ResponseDto CLIENT_NOT_FOUND_RESPONSE = new ResponseDto(ErrorCode.CLIENT_NOT_FOUND.getCode());
	private static final ResponseDto WRONG_PASSWORD_RESPONSE = new ResponseDto(ErrorCode.WRONG_PASSWORD.getCode());
	private static final ResponseDto TECHNICAL_ERROR_RESPONSE = new ResponseDto(ErrorCode.TECHNICAL_ERROR.getCode());

	@ExceptionHandler(ClientAlreadyRegisterException.class)
	public ResponseEntity<ResponseDto> handleClientAlreadyRegisterException(ClientAlreadyRegisterException ex, WebRequest request) {
		return new ResponseEntity<>(CLIENT_EXISTS_RESPONSE, HttpStatus.OK);
	}

	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<ResponseDto> handleClientNotFoundException(ClientNotFoundException ex, WebRequest request) {
		return new ResponseEntity<>(CLIENT_NOT_FOUND_RESPONSE, HttpStatus.OK);
	}

	@ExceptionHandler(WrongPasswordException.class)
	public ResponseEntity<ResponseDto> handleWrongPasswordException(WrongPasswordException ex, WebRequest request) {
		return new ResponseEntity<>(WRONG_PASSWORD_RESPONSE, HttpStatus.OK);
	}

	@ExceptionHandler(TechnicalErrorException.class)
	public ResponseEntity<ResponseDto> handleTechnicalErrorException(TechnicalErrorException ex, WebRequest request) {
		return new ResponseEntity<>(TECHNICAL_ERROR_RESPONSE, HttpStatus.OK);
	}

}

