package ro.acasa.annonLogging.service;

import org.springframework.stereotype.Service;
import ro.acasa.annonLogging.annotations.OnCall;
import ro.acasa.annonLogging.annotations.OnExit;


@Service
public class MockService {

    @OnCall(message = "Calling method with arguments %s %d")
    @OnExit(message = "Finished calling method with arguments %s %d")
    public void printSomeText(String from, int age){
        System.out.println(String.format("Some text from  %s, age %d",from, age));
    }
}
