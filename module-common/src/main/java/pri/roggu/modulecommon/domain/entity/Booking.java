package pri.roggu.modulecommon.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;
import pri.roggu.modulecommon.domain.dto.BookingDto;
import pri.roggu.modulecommon.domain.dto.TicketDto;
import pri.roggu.modulecommon.enums.BookingStatusEnum;


import java.util.List;

@Entity
@Table(name = "tBooking")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Booking extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingIdx;

    private Long ticketIdx;
    private int bookingCnt;
    @Enumerated(EnumType.STRING)
    private BookingStatusEnum bookingStatus;

    @Builder
    public Booking(TicketDto ticketDto) {
        this.ticketIdx = ticketDto.getTicketIdx();
        this.bookingCnt = ticketDto.getBookingCnt();
        this.bookingStatus = BookingStatusEnum.READY;
    }
}
