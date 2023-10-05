package pri.roggu.moduleapi.ticketing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pri.roggu.modulecore.domain.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
