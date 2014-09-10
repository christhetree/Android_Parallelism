package com.christhetree.parallelism_tsp;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by christhetree on 18/08/14.
 */
public interface ParallelTask {
    public int numberOfResults();
    public boolean execute(final long current, final Object[] results, final Object[] taskParams);
}
