package com.christhetree.parallelism_tsp;

/**
 * Created by christhetree on 01/09/14.
 */
public class ParallelTaskLibrary {


    public class GreatestFactor3 implements Command {

        @Override
        public Object executeCommand(Object... params) {
            return null;
        }
    }




    public static long GreatestFactor2(final Object... params) {
        long number = (Long) params[0];
        long start = (Long) params[1];
        long end = (Long) params[2];
        long greatestFactor = 0;
        int percentage = 0;
        for(long i = start; i < end; ++i) {
            if(number % i == 0) {
                greatestFactor = i;
            }
            percentage = (int)((((double) i) / ((double) number)) * 100.0);
            if(i % (number / 100) == 0) {
//                publishProgress(percentage);
            }
        }
        return greatestFactor;
//        return 300;
    }
}
