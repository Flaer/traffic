package ru.website.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import ru.website.data.model.Visit;

/**
 * Created by libragimov on 16.03.2018.
 */
@Service
public class AsyncSaver {


    @Autowired
    TrafficService trafficService;

    @Async
    public void saveVisit(Visit visit) {
        trafficService.saveVisit(visit);
    }

}
