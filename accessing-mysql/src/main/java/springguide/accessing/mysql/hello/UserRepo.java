package springguide.accessing.mysql.hello;

import org.springframework.data.repository.CrudRepository;
public interface UserRepo extends CrudRepository<User, Integer> {
	
}
