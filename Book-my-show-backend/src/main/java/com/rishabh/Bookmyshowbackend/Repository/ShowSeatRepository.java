package com.rishabh.Bookmyshowbackend.Repository;

import com.rishabh.Bookmyshowbackend.Models.Show;
import com.rishabh.Bookmyshowbackend.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {
    List<ShowSeat> findAllByShow(Show show);
}
