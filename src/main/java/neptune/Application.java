package neptune;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by ZHENGNE on 8/2/2018.
 */
@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan(basePackages = "neptune") // must be used, if not UserServiceImpl @Transactional will error
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(Application.class,args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder){
        return applicationBuilder.sources(Application.class);
    }
}
