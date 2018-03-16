package ru.website.data.model.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.website.data.model.User;

/**
 * Created by libragimov on 15.03.2018.
 */

public interface UsersRepository extends CrudRepository<User, String> {


}
