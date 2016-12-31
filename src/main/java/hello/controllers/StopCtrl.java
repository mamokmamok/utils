package hello.controllers;

import hello.data.Stop;
import hello.data.repositories.StopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.HTML;
import java.util.List;

/**
 * Created by Mamok-Laptop on 12/29/2016.
 */
@RestController
@Controller
public class StopCtrl {

    @Autowired
    StopRepo stopRepo;

    @RequestMapping("/test")
    public String test(){
        return "Test String";
    }

//    @RequestMapping(name = "/notworking",value = "client/index.html")
//    public ModelAndView show() {
//        ModelAndView model = new ModelAndView("index");
//        return model;
//    }

    @RequestMapping("/stops")
    public List<Stop> getAllStops(@RequestParam("city") String city){
        return stopRepo.getByCity(city);
    }
}
