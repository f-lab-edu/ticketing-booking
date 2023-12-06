package pri.roggu.modulecommon.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BookingDto {

    private Long bookingId;
    private List<TicketDto> tickets = new ArrayList<>();

}
