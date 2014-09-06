package com.christhetree.parallelism_tsp;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by christhetree on 04/09/14.
 */
public class ParallelFutureTask extends FutureTask {
    public ParallelFutureTask(Callable callable) {
        super(callable);
    }


}
