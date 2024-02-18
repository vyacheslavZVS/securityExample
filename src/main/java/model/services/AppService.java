package model.services;

import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import model.Applicaton;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class AppService {

    private List<Applicaton> applicatons;

    @PostConstruct
    public void loadAppInDB(){
        Faker faker = new Faker();
        applicatons = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> Applicaton.builder()
                        .id(i)
                        .name(faker.app().name())
                        .author(faker.app().author())
                        .version(faker.app().version())
                        .build())
                .toList();
    }

    public List<Applicaton> allApplicatons() {
        return applicatons;
    }

    public Applicaton applicatonById(int id){
        return applicatons.stream().filter(app -> app.getId() == id)
                .findFirst()
                .orElse(null);
    }

}
