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
    private Long ticketId;

    private String ticketName;
    private int quantity;

    @Builder
    public Ticket(TicketDto ticketDto) {
        this.ticketName = ticketDto.getTicketName();
        this.quantity = ticketDto.getQuantity();
    }

    /**
     * FUNCTION :: 예약 수량만큼 수량 감소
     * @param bookingCnt
     */
    public void quantityDecrease(int bookingCnt) {
        this.quantity -= bookingCnt;
    }
}
