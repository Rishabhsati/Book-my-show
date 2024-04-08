package com.rishabh.Bookmyshowbackend.Repository;

import com.rishabh.Bookmyshowbackend.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
