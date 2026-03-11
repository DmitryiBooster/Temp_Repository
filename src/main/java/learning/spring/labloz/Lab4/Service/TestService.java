package learning.spring.labloz.Lab4.Service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestService() {
    }

    public String health() {
        return "Hello from health";
    }

    public String version() {
        return "Hello from version";
    }
}
