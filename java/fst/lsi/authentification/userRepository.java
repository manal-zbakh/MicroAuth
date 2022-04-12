package fst.lsi.authentification;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import fst.lsi.entities.UserModel;

@Repository
public interface userRepository extends MongoRepository<UserModel,String>{
	
	UserModel findByUsername(String username);

}
