package pri.roggu.moduleapi.booking.service;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
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

    private static final String TOPIC = "Ticket-Issue";

    private final BookingRepository bookingRepository;
    private final TicketRepository ticketRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Transactional
    public ResponseEntity<String> booking(BookingDto bookingDto) {
        List<TicketDto> bookingTickets = bookingDto.getTickets();

        if(!CollectionUtils.isEmpty(bookingTickets)) {
            List<Booking> bookings = new ArrayList<>();
            for(TicketDto ticketDto : bookingTickets) {
                Ticket ticket = ticketRepository.findById(ticketDto.getTicketId()).orElseThrow();

                if(ticket.getQuantity() - ticketDto.getBookingCnt() < 0) {
                    throw new TicketImpossibleBookingException(ticket.getTicketName());
                }

                ticket.quantityDecrease(ticketDto.getBookingCnt());

                bookings.add(Booking.builder().ticketDto(ticketDto).build());
            }

            bookingRepository.saveAll(bookings);

            kafkaTemplate.send(TOPIC, bookingTickets);
        }

        return ResponseEntity.ok().build();
    }

}
