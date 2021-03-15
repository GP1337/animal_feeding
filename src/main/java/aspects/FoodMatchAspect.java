package aspects;

import food.Food;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class FoodMatchAspect {

    @Around("execution(void zoo.animals.Animal.feed(food))")
    public Object around(ProceedingJoinPoint joinPoint, Food food) throws Throwable {
        Object result = null;
        //before
        try {
            result = joinPoint.proceed();
            //after returning
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //after throwing
            throw throwable;
        }finally {
            //after
        }
        return result;
    }

}
