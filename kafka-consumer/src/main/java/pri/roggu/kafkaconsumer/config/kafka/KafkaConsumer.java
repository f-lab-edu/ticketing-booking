package pri.roggu.kafkaconsumer.config.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = {"Ticket-Issue"}, groupId = "booking-consumer")
    public void consumerMessage(String message) {
        log.info("Received Message : {}", message);
    }

}
