package pri.roggu.modulecommon.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pri.roggu.modulecommon.domain.dto.TicketDto;

@Entity
@Table(name = "tTicket")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Ticket extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketIdx;

    private String ticketName;
    private int quantity;

    @Builder
    public Ticket(TicketDto ticketDto) {
        this.ticketName = ticketDto.getTicketName();
        this.quantity = ticketDto.getQuantity();
    }

    public void booking(TicketDto ticketDto) {
        this.quantity -= ticketDto.getBookingCnt();
    }
}
