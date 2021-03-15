package food;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Service
public class Food {

    private LocalDateTime expiredDate;
    private FoodType foodType;
    private int value;

    public void decreaseValue (){

        value--;

    }

}
