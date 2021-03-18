package zoo.animals;

import event.AnimalIsHungryEvent;
import food.Food;
import food.FoodType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
public abstract class Animal {

    private Food food;
    private FoodType foodType;
    private final ApplicationEventPublisher publisher;

    protected Animal(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public abstract void voice();

    public void feed(Food food){

        if (food.getFoodType() != getFoodType()){
            throw new RuntimeException("Food type " + food.getFoodType() + " doesn't match to " + getClass().getSimpleName());
        }

        this.food = food;
    }

    @Scheduled(cron = "* * * * * *")
    public void eat(){

        food.decreaseValue();

    }

    public boolean foodIsOver(){
        return food == null
                || food.getExpiredDate().isBefore(LocalDateTime.now())
                || food.getValue() == 0;
    }

    public void notifyIsHungry(){
        publisher.publishEvent(new AnimalIsHungryEvent(this));
    }

}
