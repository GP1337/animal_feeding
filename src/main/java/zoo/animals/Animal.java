package zoo.animals;

import food.Food;
import food.FoodType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@Component
public abstract class Animal {

    private Food food;
    private FoodType foodType;
    private boolean hungry = true;

    public abstract void voice();

    public void feed(Food food) throws RuntimeException{

        if (food.getFoodType() != getFoodType()){
            throw new RuntimeException("Food type " + food.getFoodType() + " doesn't match to " + getClass().getSimpleName());
        }

        this.food = food;
    }

    @Scheduled(cron = "* * * * * *")
    public void eat(){

        if (foodIsOver()){
            voice();
            hungry = true;
            return;
        }

        hungry = false;

        food.decreaseValue();
        System.out.println(getClass().getSimpleName() + " eats the " + food.getFoodType());

    }

    private boolean foodIsOver(){
        return food == null
                || food.getExpiredDate().isBefore(LocalDateTime.now())
                || food.getValue() == 0;
    }

}
