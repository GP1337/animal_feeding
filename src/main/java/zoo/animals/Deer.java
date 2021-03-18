package zoo.animals;

import food.FoodType;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class Deer extends Animal{

    public Deer(ApplicationEventPublisher publisher) {
        super(publisher);
        setFoodType(FoodType.GROSS);
    }

    @Override
    public void voice() {
        System.out.println("Yeee");
    }
}
