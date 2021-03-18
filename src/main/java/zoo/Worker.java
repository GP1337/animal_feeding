package zoo;

import event.AnimalIsHungryEvent;
import food.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
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

    @EventListener
    public void animalIsHungryListener(AnimalIsHungryEvent event){
        event.getAnimal().feed(Food.builder()
                .foodType(event.getAnimal().getFoodType())
                .expiredDate(LocalDateTime.now().plusDays(1))
                .value(5)
                .build());

        System.out.println("Worker feeds the " + event.getAnimal().getClass().getSimpleName());
    }

}
