package com.rishabh.bookmyshowapplication.Repository;

import com.rishabh.bookmyshowapplication.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}