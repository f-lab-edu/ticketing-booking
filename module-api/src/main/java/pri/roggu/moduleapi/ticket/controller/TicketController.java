package pri.roggu.moduleapi.ticket.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pri.roggu.moduleapi.ticket.service.TicketService;
import pri.roggu.modulecommon.domain.dto.TicketDto;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/ticket")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping(value = "")
    public ResponseEntity<String> save(@RequestBody TicketDto ticketDto) {
        return ticketService.save(ticketDto);
    }

}
