package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import zoo.animals.Animal;

@Aspect
@Component
public class EatAspect {

    @Around(value = "execution (* zoo.animals.Animal+.eat())")
    public Object aroundEat(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = null;

        try {

            Animal animal = (Animal) joinPoint.getTarget();

            if (animal.foodIsOver()){
                animal.voice();
                animal.notifyIsHungry();
            }
            else {
                result = joinPoint.proceed();
                System.out.println(animal.getClass().getSimpleName() + " eats the " + animal.getFoodType());
            }

        } catch (Throwable throwable) {

            throw throwable;

        }finally {

        }
        return result;

    }

}
