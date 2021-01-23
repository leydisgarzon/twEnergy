package uk.tw.energy.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import uk.tw.energy.vo.RestApiResponse;
import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.util.Date;
import static java.util.stream.Collectors.joining;

@RestControllerAdvice
public class ControllerExceptionHandler{

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public final ResponseEntity<Object> handleResponseStatusException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        RestApiResponse response = RestApiResponse.builder()
                .message("")
                .error(ex.getBindingResult().getFieldErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(joining("\n")))
                .timestamp(Date.from(Instant.now()))
                .status(HttpStatus.BAD_REQUEST.value())
                .path(request.getRequestURI()).build();
        return ResponseEntity.badRequest()
                .body(response);
    }
}
