package ru.website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.website.data.TrafficService;
import ru.website.data.model.Visit;
import ru.website.responses.ExternalStatistic;
import ru.website.responses.Statistic;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by libragimov on 15.03.2018.
 */
@RestController
public class TrafficController {

    @Autowired
    TrafficService trafficService;

    @PostMapping(value = "/visit")
    public Statistic visit(@RequestBody Visit visit) {
        trafficService.saveVisit(visit);
        return trafficService.calculateDailyStatistic();
    }

    /*
        @GetMapping(value = "/visit")
    public Statistic visit(@RequestParam(value="userId") String userId, @RequestParam(value="pageId") String pageId) {
        trafficService.saveVisit(userId, pageId);
        return trafficService.calculateDailyStatistic();
    }
     */

    @GetMapping(value = "/statistics")
    public ExternalStatistic statistics(@RequestParam("start")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                                    @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        LocalDateTime start = startDate.atStartOfDay();
        LocalDateTime end = endDate.atStartOfDay();
        return trafficService.calculateFullStatistic(start, end);
    }
}