package pri.roggu.moduleapi.ticket.repository;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import pri.roggu.modulecommon.domain.entity.Ticket;

import java.util.Optional;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Ticket> findById(Long ticketId);

    Optional<Ticket> findByTicketName(String ticketName);

}
