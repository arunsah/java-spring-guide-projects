package springguide.securing.webapps;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import springguide.securing.webapps.storage.StorageProperties;
import springguide.securing.webapps.storage.StorageService;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class App 
{
    public static void main( String[] args ) throws Throwable
    {
        SpringApplication.run(App.class, args);
    }
    
    @Bean
    CommandLineRunner init(final StorageService storageService) {
    	return args->{
    		storageService.deleteAll();
    		storageService.init();
    	};
    }
}
