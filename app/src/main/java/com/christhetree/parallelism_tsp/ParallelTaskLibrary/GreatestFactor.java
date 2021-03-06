package com.christhetree.parallelism_tsp.ParallelTaskLibrary;

import com.christhetree.parallelism_tsp.ParallelTask;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by christhetree on 08/09/14.
 */
public class GreatestFactor implements ParallelTask {
    @Override
    public int numberOfResults() {
        return 1;
    }

    @Override
    public boolean execute(final long current, final Object[] results, final Object[] taskParams) {
        if((Long) taskParams[0] % current == 0) {
            results[0] = current;
            return true;
        } else {
            if(results[0] == null) {
                results[0] = (long) 1;
            }
            return false;
        }
    }
}
