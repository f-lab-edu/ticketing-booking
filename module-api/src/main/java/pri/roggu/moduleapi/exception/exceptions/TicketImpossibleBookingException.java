package pri.roggu.moduleapi.exception.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TicketImpossibleBookingException extends RuntimeException{

    private final String ticketName;
}
