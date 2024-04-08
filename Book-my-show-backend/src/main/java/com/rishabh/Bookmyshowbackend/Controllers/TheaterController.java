package com.rishabh.Bookmyshowbackend.Controllers;

<<<<<<< HEAD:Book-my-show-backend/src/main/java/com/rishabh/Bookmyshowbackend/Controllers/TheaterController.java
import com.rishabh.Bookmyshowbackend.Requests.AddTheaterRequest;
import com.rishabh.Bookmyshowbackend.Service.TheaterService;
=======
import com.rishabh.bookmyshowapplication.Requests.AddTheaterRequest;
import com.rishabh.bookmyshowapplication.Service.TheaterService;
>>>>>>> 593fa918fd0c85862a9d38ce31b6cab0d036655d:book-my-show-application/src/main/java/com/rishabh/bookmyshowapplication/Controllers/TheaterController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addTheater")
    public ResponseEntity<String> addTheater(@RequestBody AddTheaterRequest addTheaterRequest){
        String response = theaterService.addTheater(addTheaterRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
