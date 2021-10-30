package ai.tech.web.exception.handler;

import ai.tech.web.exception.ExceptionResponse;
import ai.tech.web.exception.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler
  protected ResponseEntity<Object> handleExceptions(Exception exception, WebRequest webRequest) {
    ExceptionResponse exceptionResponse =
        ExceptionResponse.builder()
            .timeStamp(new Date())
            .message(exception.getMessage())
            .detail(webRequest.getDescription(false))
            .build();

    return ResponseEntity.internalServerError().body(exceptionResponse);
  }

  @ExceptionHandler
  protected ResponseEntity<Object> handleUserNotFoundException(
          NotFoundException notFoundException, WebRequest webRequest) {
    ExceptionResponse exceptionResponse =
        ExceptionResponse.builder()
            .timeStamp(new Date())
            .message(notFoundException.getMessage())
            .detail(webRequest.getDescription(false))
            .build();

    return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException methodArgumentNotValidException,
      HttpHeaders httpHeaders,
      HttpStatus httpStatus,
      WebRequest webRequest) {
    ExceptionResponse exceptionResponse =
        ExceptionResponse.builder()
            .timeStamp(new Date())
            .message("Validation failed.")
            .detail(methodArgumentNotValidException.getBindingResult().toString())
            .build();

    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
