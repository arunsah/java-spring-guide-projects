package springguide.accessing.mysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 * http://localhost:9004/user/all
 * [{"id":1,"name":"tom","email":"tom@gmail.com"},{"id":2,"name":"hal","email":"hal@gmail.com"}]
 * $ curl localhost:9004/user/add -d name=tom -d email=tom@gmail.com
 */

@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
