package pri.roggu.modulecommon.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDto {

    private Long ticketId;
    private String ticketName;
    private int quantity;
    private int bookingCnt;

}
