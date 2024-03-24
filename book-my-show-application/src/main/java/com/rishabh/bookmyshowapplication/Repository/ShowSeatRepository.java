package com.rishabh.bookmyshowapplication.Repository;

import com.rishabh.bookmyshowapplication.Models.Show;
import com.rishabh.bookmyshowapplication.Models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {

    public List<ShowSeat> findAllByShow(Show show);
}
