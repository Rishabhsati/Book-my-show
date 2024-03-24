package com.rishabh.bookmyshowapplication.Service;

import com.rishabh.bookmyshowapplication.Models.Theater;
import com.rishabh.bookmyshowapplication.Repository.TheaterRepository;
import com.rishabh.bookmyshowapplication.Requests.AddTheaterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(AddTheaterRequest addTheaterRequest) {

        //Convert this AddRequest to an Entity

        //how to do this ??

        //Use a constructor to create an object : Generally constructors are not available

//        Theater theater = new Theater(); //creating theater object

//        this is the old method of creating object

//        theater.setTheaterName(addTheaterRequest.getName());
//        theater.setAddress(addTheaterRequest.getAddress());
//        theater.setNoOfScreens(addTheaterRequest.getNoOfScreens());

//        new metod of creating object using builder annotaion which is provided by the lombok


        Theater theater = Theater.builder().theaterName(addTheaterRequest.getName())
                .address(addTheaterRequest.getAddress())
                .noOfScreens(addTheaterRequest.getNoOfScreens()).build();

        theater = theaterRepository.save(theater);
        return "Theater has been added to the db with theaterId "+theater.getTheaterId();
    }

}
