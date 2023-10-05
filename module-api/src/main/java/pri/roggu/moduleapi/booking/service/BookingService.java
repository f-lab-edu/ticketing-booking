package pri.roggu.moduleapi.booking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pri.roggu.moduleapi.booking.repository.BookingRepository;
import pri.roggu.moduleapi.exception.exceptions.TicketImpossibleBookingException;
import pri.roggu.moduleapi.ticket.repository.TicketRepository;
import pri.roggu.modulecommon.domain.dto.BookingDto;
import pri.roggu.modulecommon.domain.dto.TicketDto;
import pri.roggu.modulecommon.domain.entity.Booking;
import pri.roggu.modulecommon.domain.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;

    @Transactional
    public ResponseEntity<String> booking(BookingDto bookingDto) {
        List<TicketDto> bookingTickets = bookingDto.getTickets();
        if(bookingValidation(bookingTickets)) {
            List<Booking> bookings = new ArrayList<>();
            for(TicketDto ticketDto : bookingTickets) {
                bookings.add(Booking.builder().ticketDto(ticketDto).build());
            }

            bookingRepository.saveAll(bookings);
        }

        return ResponseEntity.ok().build();
    }

    /**
     * FUNCTION :: 티켓 예약 유효성 검사
     * @param ticketList
     * @return
     */
    private boolean bookingValidation(List<TicketDto> ticketList) {
        List<Long> ticketIdxs = ticketList.stream().map(TicketDto::getTicketIdx).toList();
        List<Ticket> tickets = ticketRepository.findAllByTicketIdxIn(ticketIdxs);

        for(Ticket ticket : tickets) {
            if(ticket.getQuantity() < 1) {
                throw new TicketImpossibleBookingException(ticket.getTicketName());
            }
        }

        return true;
    }

}
