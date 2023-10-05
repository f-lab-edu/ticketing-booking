package pri.roggu.moduleapi.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pri.roggu.modulecommon.domain.entity.Ticket;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Long> {

    Optional<Ticket> findByTicketName(String ticketName);

    List<Ticket> findAllByTicketIdxIn(List<Long> ticketIdxs);

}
