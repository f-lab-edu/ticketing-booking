package pri.roggu.modulecore.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pri.roggu.modulecore.exception.exceptions.UserDuplicateException;
import pri.roggu.modulecore.exception.exceptions.UserLoginException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * FUNCTION :: DTO 파라미터 @Valid Exception Handler
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        StringBuffer sb = new StringBuffer();

        result.getFieldErrors()
                .forEach(
                        fieldError -> {
                            sb.append("\"")
                                    .append(fieldError.getField())
                                    .append("\"")
                                    .append(" : ")
                                    .append(fieldError.getDefaultMessage());
                        }
                );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(sb.toString());
    }

    /**
     * FUNCTION :: 사용자 중복
     * @param e
     * @return
     */
    @ExceptionHandler(UserDuplicateException.class)
    public ResponseEntity<String> userDuplicateException(UserDuplicateException e) {
        log.info("User ["+ e.getUserId() +"] Duplicated Id");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    /**
     * FUNCTION :: 사용자 로그인 실패
     * @param e
     * @return
     */
    @ExceptionHandler(UserLoginException.class)
    public ResponseEntity<String> userLoginException(UserLoginException e) {
        log.info("User ["+ e.getUserId() +"] Login Fail");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}