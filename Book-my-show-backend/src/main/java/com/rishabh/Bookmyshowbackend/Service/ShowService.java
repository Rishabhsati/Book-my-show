package com.rishabh.Bookmyshowbackend.Service;

import com.rishabh.Bookmyshowbackend.DTOs.ShowByMovieDto;
import com.rishabh.Bookmyshowbackend.DTOs.ShowByTheaterDto;
import com.rishabh.Bookmyshowbackend.Enums.SeatType;
import com.rishabh.Bookmyshowbackend.Models.*;
import com.rishabh.Bookmyshowbackend.Repository.*;
import com.rishabh.Bookmyshowbackend.Requests.AddShowRequest;
import com.rishabh.Bookmyshowbackend.Requests.AddShowSeatRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
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

    public List<ShowByMovieDto> getShowByMovie(String movieName) throws Exception{
        List<Show> list = showRepository.findAll();
        List<ShowByMovieDto> ansList = new ArrayList<>();
        boolean flag = false;
        for (Show show:list) {
            Movie movie = show.getMovie();
            if((movie!=null) && movie.getMovieName().equals(movieName)){
                flag = true;
                Theater theater = show.getTheater();
                ShowByMovieDto showByMovieDto = new ShowByMovieDto();
                showByMovieDto.setShowDate(show.getShowDate());
                showByMovieDto.setShowTime(show.getShowTime());
                showByMovieDto.setTheaterName(theater.getTheaterName());
                showByMovieDto.setTheaterAdd(theater.getAddress());
                ansList.add(showByMovieDto);
            }
        }
        if(!flag){
            throw new Exception("Shows are not available "+ movieName);
        }
        return ansList;
    }

    public List<ShowByTheaterDto> getShowByTheater(String theaterName) throws Exception{
        List<ShowByTheaterDto> ansList = new ArrayList<>();
        List<Show> list = showRepository.findAll();
        boolean flag = false;
        for (Show show:list) {
            Theater theater = show.getTheater();
            if((show.getMovie()!=null)&& (theater!=null) && theater.getTheaterName().equals(theaterName)){
                flag = true;
                Movie movie = show.getMovie();
                ShowByTheaterDto showByTheaterDto = new ShowByTheaterDto();

                showByTheaterDto.setMovieName(movie.getMovieName());
                showByTheaterDto.setTheaterAdd(theater.getAddress());
                showByTheaterDto.setShowDate(show.getShowDate());
                showByTheaterDto.setShowTime(show.getShowTime());
                ansList.add(showByTheaterDto);
            }
        }
        if(!flag){
            throw new Exception("Shows are not available " + theaterName);
        }
        return ansList;
    }
}
