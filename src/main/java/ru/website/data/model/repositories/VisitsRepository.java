package ru.website.data.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.website.data.model.Visit;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by libragimov on 16.03.2018.
 */
public interface VisitsRepository  extends CrudRepository<Visit, String> {

    @Query("select count(v) from Visit v where v.created between :start and :end")
    Long calculateVisitsByPeriod(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query("select count(distinct v.userId) from Visit v where v.created between :start and :end")
    Long calculateUniqueUsersByPeriod(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    /*
     todo refactor to view
     */
    @Query("select count(u) from User u where u.id in (select v.userId from Visit v where v.created between :start and :end group by v.userId having count(v.pageId) >= 10)")
    Long calculateRegularUsersByPeriod(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}
