package com.rishabh.bookmyshowapplication.Service;

import com.rishabh.bookmyshowapplication.Enums.SeatType;
import com.rishabh.bookmyshowapplication.Models.Theater;
import com.rishabh.bookmyshowapplication.Models.TheaterSeat;
import com.rishabh.bookmyshowapplication.Repository.TheaterRepository;
import com.rishabh.bookmyshowapplication.Repository.TheaterSeatRepository;
import com.rishabh.bookmyshowapplication.Requests.AddTheaterSeatsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterSeatService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatRepository theaterSeatRepository;

    public String addTheaterSeats(AddTheaterSeatsRequest addTheaterSeatsRequest) {
        int noOfClassicSeats = addTheaterSeatsRequest.getNoOfClassicSeats();
        int noOfPremiumSeats = addTheaterSeatsRequest.getNoOfPremiumSeats();

        Integer theaterId = addTheaterSeatsRequest.getTheaterId();
        Theater theater = theaterRepository.findById(theaterId).get();

        int classicSeatCounter = 1;
        char ch = 'A';
        int rowNo = 1;

        List<TheaterSeat> list = new ArrayList<>();
        while(classicSeatCounter<=noOfClassicSeats){
            String seatNo = rowNo+""+ch;
            // adding theater seat in the theater seat object
            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo).seatType(SeatType.CLASSIC).theater(theater).build();
            // adding seat into the theater seat list
            list.add(theaterSeat);
            ch++;
            if(classicSeatCounter%5==0){
                ch = 'A';
                rowNo++;
            }
            classicSeatCounter++;
        }

        if(classicSeatCounter%5!=1) rowNo+=1;

        int premiumSeatCounter = 1;
        ch = 'A';

        while(premiumSeatCounter<=noOfClassicSeats) {
            String seatNo = rowNo + "" + ch;
            // adding theater seat in the theater seat object
            TheaterSeat theaterSeat = TheaterSeat.builder().seatNo(seatNo).seatType(SeatType.PREMIUM).theater(theater).build();
            // adding seat into the theater seat list
            list.add(theaterSeat);
            ch++;
            if (premiumSeatCounter % 5 == 0) {
                ch = 'A';
                rowNo++;
            }
            premiumSeatCounter++;
        }
        theaterSeatRepository.saveAll(list);
        return "Theater seats have been generated";
    }
}
