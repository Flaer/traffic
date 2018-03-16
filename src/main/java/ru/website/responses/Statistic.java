package ru.website.responses;

/**
 * Response for visit
 * Created by libragimov on 15.03.2018.
 */
public class Statistic {
    private final Long uniqueUsersAmount;
    private final Long visitsAmount;

    public Statistic(Long uniqueUsersAmount, Long visitsAmount) {
        this.uniqueUsersAmount = uniqueUsersAmount;
        this.visitsAmount = visitsAmount;
    }

    public Long getUniqueUsersAmount() {
        return uniqueUsersAmount;
    }

    public Long getVisitsAmount() {
        return visitsAmount;
    }
}
