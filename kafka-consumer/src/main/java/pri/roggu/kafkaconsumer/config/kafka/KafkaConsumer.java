package pri.roggu.kafkaconsumer.config.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import pri.roggu.modulecommon.domain.dto.TicketDto;

import java.util.List;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "Ticket-Issue", groupId = "booking-consumer", containerFactory = "kafkaListenerContainerFactory")
    public void consumerMessage(List<TicketDto> bookingTickets) {

        bookingTickets.forEach(booking -> {
            System.out.println("티켓 Id : " + booking.getTicketId() + ", 수량 : " + booking.getBookingCnt());
        });
    }

}
