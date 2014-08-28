package com.christhetree.parallelism_tsp;

/**
 * Created by christhetree on 18/08/14.
 */
public interface Command {
    public void execute(final int index, final Object data, final Object view);
}
