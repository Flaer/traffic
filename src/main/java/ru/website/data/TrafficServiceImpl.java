package ru.website.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.website.data.model.Page;
import ru.website.data.model.User;
import ru.website.data.model.Visit;
import ru.website.data.model.repositories.PagesRepository;
import ru.website.data.model.repositories.UsersRepository;
import ru.website.data.model.repositories.VisitsRepository;
import ru.website.responses.ExternalStatistic;
import ru.website.responses.Statistic;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * Created by libragimov on 15.03.2018.
 */
@Service
public class TrafficServiceImpl implements TrafficService {

    private final UsersRepository usersRepository;
    private final PagesRepository pagesRepository;
    private final VisitsRepository visitsRepository;

    @Autowired
    public TrafficServiceImpl(PagesRepository pagesRepository, UsersRepository usersRepository, VisitsRepository visitsRepository) {
        this.pagesRepository = pagesRepository;
        this.usersRepository = usersRepository;
        this.visitsRepository = visitsRepository;
    }

    public void saveVisit(Visit visit) {
        // todo throw exception if user not found
        // todo throw exception if page not found
        // для тестирования не найденный пользователь и страница сохраняются в справочнике
        if(Optional.empty().equals(usersRepository.findById(visit.getUserId())))
            usersRepository.save(new User(visit.getUserId()));
        if(Optional.empty().equals(pagesRepository.findById(visit.getPageId())))
            pagesRepository.save(new Page(visit.getPageId()));

        visitsRepository.save(visit);
    }

    public Statistic calculateDailyStatistic() {
        // todo throw exception if sartDate greater then endDate
        // todo throw exception if date format is wrong
        LocalDateTime startDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
        LocalDateTime endDate = startDate.plusDays(1);
        Long visitsByDate = visitsRepository.calculateVisitsByPeriod(startDate, endDate);
        Long uniqueUsersByDate = visitsRepository.calculateUniqueUsersByPeriod(startDate, endDate);

        return new Statistic(uniqueUsersByDate, visitsByDate);
    }

    @Override
    public ExternalStatistic calculateFullStatistic(LocalDateTime start, LocalDateTime end) {
        Long visitsByDate = visitsRepository.calculateVisitsByPeriod(start, end);
        Long uniqueUsersByDate = visitsRepository.calculateUniqueUsersByPeriod(start, end);
        Long regularUsersByDate = visitsRepository.calculateRegularUsersByPeriod(start, end);

        return new ExternalStatistic(uniqueUsersByDate, visitsByDate, regularUsersByDate);
    }
}
