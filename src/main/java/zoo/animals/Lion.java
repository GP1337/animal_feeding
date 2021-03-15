package zoo.animals;

import food.FoodType;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Lion extends Animal{

    public Lion(ApplicationEventPublisher applicationEventPublisher) {
        setFoodType(FoodType.MEAT);
    }

    @Override
    public void voice() {
        System.out.println("Arrrr");
    }
}
