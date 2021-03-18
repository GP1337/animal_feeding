package zoo;

import org.springframework.stereotype.Service;
import zoo.animals.Animal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@Service
public class Zoo {

    private final List<Animal> animalList;
    private final Worker worker;

    @Autowired
    public Zoo(List<Animal> animalList, Worker worker) {

        this.animalList = animalList;
        this.worker = worker;

//        worker.feedAnimals();

    }
}
