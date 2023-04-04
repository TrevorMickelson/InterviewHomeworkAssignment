package org.interview.homeworkassignment;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class TransactionPointsCalculator {
    @RequestMapping("/transaction-points")
    @ResponseBody
    public int getPointsEarnedFromTransaction(@RequestParam("transactionAmount") int amount) {
        return getPointsBetweenFiftyAndOneHundred(amount) + getPointsPastOneHundred(amount);
    }

    /**
     * Every dollar between 50 and 100 is worth 1 point,
     * this function calculates the number of points between
     * 50 and 100 (if relevant)
     * <p>
     * If it's not relevant, 0 is returned
     */
    private int getPointsBetweenFiftyAndOneHundred(int amount) {
        if (amount < 50) return 0;

        // The max available option is 50
        return Math.min(amount - 50, 50);
    }

    /**
     * Every dollar past 100 is worth 2 points, this function
     * calculates that number of points
     * <p>
     * If not relevant, 0 is returned
     */
    private int getPointsPastOneHundred(int amount) {
        if (amount <= 100) return 0;

        return (amount - 100) * 2;
    }
}
