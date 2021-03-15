package configuration;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(value = {"zoo"})
@EnableAspectJAutoProxy
@EnableScheduling
@EnableAsync
public class AnnotationConfiguration {

}
