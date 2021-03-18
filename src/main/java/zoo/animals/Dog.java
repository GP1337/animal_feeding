package zoo.animals;

import food.FoodType;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Dog extends Animal{

    public Dog(ApplicationEventPublisher publisher) {
        super(publisher);
        setFoodType(FoodType.MEAT);
    }

    @Override
    public void voice() {
        System.out.println("Bark");
    }
}
