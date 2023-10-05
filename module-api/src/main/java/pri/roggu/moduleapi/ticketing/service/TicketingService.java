package pri.roggu.moduleapi.ticketing.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pri.roggu.moduleapi.ticketing.repository.TicketRepository;

@Service
@RequiredArgsConstructor
public class TicketingService {

    private final TicketRepository ticketRepository;

    public String booking() {
        return "";
    }

}
