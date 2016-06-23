package hotel.swap.demo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@SpringBootApplication
@EnableJpaRepositories
public class HotelSwapDemoApplication extends SpringBootServletInitializer {

    private static final Log LOG = LogFactory.getLog(HotelSwapDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HotelSwapDemoApplication.class, args);
    }
}
