package springguide.securing.webapps;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springguide.securing.webapps.storage.StorageProperties;
import springguide.securing.webapps.storage.StorageService;

/**
 * Hello world!
 *
 */
@ComponentScan(basePackages = { "springguide.securing.webapps.storage", "springguide.securing.webapps",
		"springguide.securing.webapps.hello" })
@SpringBootApplication(scanBasePackages = { "springguide.securing.webapps", "springguide.securing.webapps.hello",
		"springguide.securing.webapps.storage" })
@EnableConfigurationProperties(StorageProperties.class)
public class App implements CommandLineRunner {
	@Autowired
	ApplicationContext applicationContext;

	public static void main(String[] args) throws Throwable {

		SpringApplication.run(App.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		String[] beans = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beans);
		for (String bean : beans) {
			System.out.println(bean);
		}

	}

	private void printBeans() {
		System.out.println("Printing all beans...");
		System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));

	}

	@Bean
	CommandLineRunner init(final StorageService storageService) {
//    	System.out.println("Printing all beans...");
//    	System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
		return args -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
