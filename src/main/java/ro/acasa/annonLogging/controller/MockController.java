package ro.acasa.annonLogging.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.acasa.annonLogging.service.MockService;

@Controller
public class MockController {

    @Autowired
    MockService service;

    @ResponseBody
    @RequestMapping("/mock")
    public String mockMethod(){
        service.printSomeText("John", 14);
        return "Done!";
    }

}
