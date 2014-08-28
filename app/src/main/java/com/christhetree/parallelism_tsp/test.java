package com.christhetree.parallelism_tsp;

/**
 * Created by christhetree on 18/08/14.
 */
public class test {
    public static void CallCommand(final int index, final Command command, final Object data, final Object view) {
        command.execute(index, data, view);
    }
}
