package zoo.animals;

import food.FoodType;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Cat extends Animal{

    public Cat(ApplicationEventPublisher publisher) {
        super(publisher);
        setFoodType(FoodType.FISH);
    }

    @Override
    public void voice() {
        System.out.println("Meow");
    }

    // Overriding eat schedule
    @Override
    @Scheduled(cron = "1 * * * * *")
    public void eat(){
        super.eat();
    }
}
