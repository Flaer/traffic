package ru.website.data.model.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.website.data.model.Page;

/**
 * Created by libragimov on 15.03.2018.
 */
public interface PagesRepository extends CrudRepository<Page, String> {

}
