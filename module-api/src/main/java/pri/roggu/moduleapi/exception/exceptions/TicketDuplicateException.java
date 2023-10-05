package pri.roggu.moduleapi.exception.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TicketDuplicateException extends RuntimeException{

    private final String ticketName;
}
