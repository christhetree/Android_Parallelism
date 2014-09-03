package com.christhetree.parallelism_tsp;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by christhetree on 02/09/14.
 */
public class ParallelFutureTask extends FutureTask<Object> {


    public ParallelFutureTask(final Callable callable) {
        super(callable);
    }
}
