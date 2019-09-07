package springguide.restful.webservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import springguide.restful.webservice.consumer.hello.Quote;

/**
 * Hello world!
 *
 */

@SpringBootApplication
public class App 
{
	private static final Logger log=LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
    	RestTemplate template = new RestTemplate();
    	String url = "https://gturnquist-quoters.cfapps.io/api/random";
    	Quote quote = template.getForObject(url, Quote.class);
    	log.info(quote.toString());
        
    }
}
