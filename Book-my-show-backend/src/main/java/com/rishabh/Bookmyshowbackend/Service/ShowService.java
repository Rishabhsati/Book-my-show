package com.rishabh.Bookmyshowbackend.Service;

import com.rishabh.Bookmyshowbackend.Enums.SeatType;
import com.rishabh.Bookmyshowbackend.Models.*;
import com.rishabh.Bookmyshowbackend.Repository.*;
import com.rishabh.Bookmyshowbackend.Requests.AddShowRequest;
import com.rishabh.Bookmyshowbackend.Requests.AddShowSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private TheaterRepository theaterRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private TheaterSeatRepository theaterSeatRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;


    public String addShow(AddShowRequest showRequest) {
        Movie movie = movieRepository.findMovieByMovieName(showRequest.getMovieName());

        Theater theater = theaterRepository.findById(showRequest.getTheaterId()).get();

        Show show = Show.builder().showDate(showRequest.getShowDate())
                .showTime(showRequest.getShowTime())
                .theater(theater).movie(movie).build();

        show = showRepository.save(show);
        return "show has been added successfully with the showId "+show.getShowId();
    }

    public String addShowSeats(AddShowSeatRequest showSeatRequest) {
//        find  show by showId
        Integer showId = showSeatRequest.getShowId();
//        get the show
        Show show = showRepository.findById(showId).get();
//        get the theater

        Theater theater = show.getTheater();
        List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();


//        now creating seat list for showing to frontend
        List<ShowSeat> showSeatList = new ArrayList<>();

//        now task is to create seat list
        for(TheaterSeat theaterSeat : theaterSeatList){
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNo(theaterSeat.getSeatNo())
                    .seatType(theaterSeat.getSeatType())
                    .isAvailable(Boolean.TRUE)
                    .show(show).build();

            if(theaterSeat.getSeatType().equals(SeatType.CLASSIC)){
                showSeat.setPrice(showSeatRequest.getPriceOfClassicSeats());
            }else{
                showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeats());
            }
            showSeatList.add(showSeat);
        }
        showSeatRepository.saveAll(showSeatList);
        return "Show seats have been generated for the given showId " + showId;
    }
}
