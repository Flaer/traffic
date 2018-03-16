package ru.website.data;

import ru.website.data.model.Visit;
import ru.website.responses.ExternalStatistic;
import ru.website.responses.Statistic;

import java.time.LocalDateTime;

/**
 * Created by libragimov on 15.03.2018.
 */
public interface TrafficService {

    void saveVisit(Visit visit);
    Statistic calculateDailyStatistic();
    ExternalStatistic calculateFullStatistic(LocalDateTime start, LocalDateTime end);
}
