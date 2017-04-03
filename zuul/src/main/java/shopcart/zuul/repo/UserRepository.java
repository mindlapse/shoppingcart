package shopcart.zuul.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import shopcart.zuul.model.User;

public interface UserRepository extends MongoRepository<User, String> {
}
