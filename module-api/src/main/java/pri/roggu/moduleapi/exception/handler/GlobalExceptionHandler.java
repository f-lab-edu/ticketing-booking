package pri.roggu.moduleapi.exception.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pri.roggu.moduleapi.exception.exceptions.TicketDuplicateException;
import pri.roggu.moduleapi.exception.exceptions.TicketImpossibleBookingException;

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
     * FUNCTION :: 티켓 중복 등록 예외
     * @param e
     * @return
     */
    @ExceptionHandler(TicketDuplicateException.class)
    public ResponseEntity<String> ticketDuplicateException(TicketDuplicateException e) {
        log.info("Ticket ["+ e.getTicketName() +"] Duplicated");
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    /**
     * FUNCTION :: 예약 불가 티켓 예약 요청 예외
     * @param e
     * @return
     */
    @ExceptionHandler(TicketImpossibleBookingException.class)
    public ResponseEntity<String> ticketImpossibleBookingException(TicketImpossibleBookingException e) {
        log.info("Ticket ["+ e.getTicketName() +"] Booking Impossible By Insufficient Quantity");
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }
}
