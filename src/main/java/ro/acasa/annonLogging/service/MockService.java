package ro.acasa.annonLogging.service;

import org.springframework.stereotype.Service;
import ro.acasa.annonLogging.annotations.OnCall;
import ro.acasa.annonLogging.annotations.OnExit;


@Service
public class MockService {

    @OnCall(message = "Calling method")
    @OnExit(message = "Finished calling method")
    public void printSomeText(){
        System.out.println("Some text");
    }
}
