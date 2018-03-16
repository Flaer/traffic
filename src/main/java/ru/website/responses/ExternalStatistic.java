package ru.website.responses;

/**
 * Created by libragimov on 15.03.2018.
 */
public class ExternalStatistic extends Statistic {
    private final Long regularUsersAmount;

    public ExternalStatistic(Long uniqueUsersAmount, Long visitsAmount, Long regularUsersAmount) {
        super(uniqueUsersAmount, visitsAmount);
        this.regularUsersAmount = regularUsersAmount;
    }

    public Long getRegularUsersAmount() {
        return regularUsersAmount;
    }
}
