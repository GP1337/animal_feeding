package zoo;

import food.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import zoo.animals.Animal;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class Worker {

    private List<Animal> animalList;

    @Autowired
    public Worker(List<Animal> animalList) {
        this.animalList = animalList;
    }

    @Scheduled(cron = "1 * * * * *")
    public void feedAnimals(){

        animalList.forEach(animal -> {
            if (animal.isHungry()){
                animal.feed(Food.builder()
                        .foodType(animal.getFoodType())
                        .expiredDate(LocalDateTime.now().plusDays(1))
                        .value(20)
                        .build());

                System.out.println("Worker feeds the " + animal.getClass().getSimpleName());
            }
        });

    }

}
