package pri.roggu.moduleapi.ticket.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pri.roggu.moduleapi.exception.exceptions.TicketDuplicateException;
import pri.roggu.modulecommon.domain.dto.TicketDto;
import pri.roggu.modulecommon.domain.entity.Ticket;
import pri.roggu.moduleapi.ticket.repository.TicketRepository;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    public ResponseEntity<String> save(TicketDto ticketDto) {

        ticketRepository.findByTicketName(ticketDto.getTicketName()).ifPresent(
                ticket -> {
                    throw new TicketDuplicateException(ticketDto.getTicketName());
                }
        );

        Ticket ticket = Ticket.builder()
                .ticketDto(ticketDto)
                .build();

        ticketRepository.save(ticket);

        return ResponseEntity.ok().build();
    }

}
