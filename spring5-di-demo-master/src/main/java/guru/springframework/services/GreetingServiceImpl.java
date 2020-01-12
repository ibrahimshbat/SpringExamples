package guru.springframework.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService{
    public static final String GREETING = "Hello World";
    @Override
    public java.lang.String sayGreeting() {
        return GREETING;
    }
}
