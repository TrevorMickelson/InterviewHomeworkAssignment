package com.interview.homeworkassignment;

import org.interview.homeworkassignment.TransactionPointsCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

public class TransactionPointsCalculatorTest {
    private static final int COLLECTION_SIZE = 1000;
    private static final int MAX_TRANSACTION_TEST_SIZE = 200;
    private final Collection<Integer> cachedDataCollectionList = new ArrayList<>();

    /**
     * This is more of a manual test to see if the
     * function works properly, this will always
     * say the test passed, this was merely used
     * as an example to the function itself
     * <p>
     * After reviewing the return values from the points'
     * calculator, I've determined this function fully works
     */
    @Test
    public void testTransactionPointsCalculator() {
        cleanAndFillCachedDataCollection();
        TransactionPointsCalculator pointsCalculator = new TransactionPointsCalculator();

        cachedDataCollectionList.forEach(amount -> {
            System.out.printf("Given amount: %s... Calculated points: %s%n",
                    amount, pointsCalculator.getPointsEarnedFromTransaction(amount));
        });
    }

    private void cleanAndFillCachedDataCollection() {
        cachedDataCollectionList.clear();
        Random random = new Random();

        for (int i = 0; i < COLLECTION_SIZE; i++) {
            cachedDataCollectionList.add(random.nextInt(MAX_TRANSACTION_TEST_SIZE) + 1);
        }
    }
}
