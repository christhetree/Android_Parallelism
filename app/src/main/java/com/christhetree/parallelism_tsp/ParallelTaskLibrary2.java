package com.christhetree.parallelism_tsp;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by christhetree on 01/09/14.
 */
public class ParallelTaskLibrary2 {
    public static boolean GreatestFactor(final long current, final Object[] results, final Object[] taskParams) {
//        long number = (Long) params[0];
//        long start = (Long) params[1];
//        long end = (Long) params[2];
//        long greatestFactor = 0;
//        int percentage = 0;
//        for(long i = start; i < end; ++i) {
//            if(number % i == 0) {
//                greatestFactor = i;
//            }
//            percentage = (int)((((double) i) / ((double) number)) * 100.0);
//            if(i % (number / 100) == 0) {
//                publishProgress(percentage);
//            }
//        }
//        return greatestFactor;
        if((Long) taskParams[0] % current == 0) {
            results[0] = current;
            return true;
        } else {
            return false;
        }
    }
}
