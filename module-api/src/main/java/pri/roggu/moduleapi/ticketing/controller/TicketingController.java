package pri.roggu.moduleapi.ticketing.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.roggu.moduleapi.ticketing.service.TicketingService;

@RestController
@RequiredArgsConstructor
public class TicketingController {

    private final TicketingService ticketingService;

    @PostMapping(value = "/booking")
    public String booking() {
        return ticketingService.booking();
    }


}