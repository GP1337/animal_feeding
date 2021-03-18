package event;

import lombok.Getter;
import zoo.animals.Animal;

@Getter
public class AnimalIsHungryEvent {

    private final Animal animal;

    public AnimalIsHungryEvent(Animal animal) {
        this.animal = animal;
    }
}
