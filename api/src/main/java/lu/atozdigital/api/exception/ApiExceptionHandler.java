package lu.atozdigital.api.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(value = {ApiRestException.class})
	public ResponseEntity<Object> ExceprionHandler(ApiRestException e){
		
		HttpStatus status = HttpStatus.BAD_REQUEST; 
		
		ApiException exception = new ApiException(
				e.getMessage(), 
				status,
				ZonedDateTime.now(ZoneId.of("GMT"))
				);
		return new ResponseEntity <Object> (exception, status);
	}
}
