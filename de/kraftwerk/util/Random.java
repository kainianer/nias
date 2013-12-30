/*
 *  Copyright 2013 by Kraftwerk Productions
 *  Do not distribute!
 * 
 */
package de.kraftwerk.util;

/**
 *
 * @author kainianer
 */
public class Random {

    public static int getInteger(int start, int end) {
        java.util.Random ran = new java.util.Random();
        int puffer = ran.nextInt(end);
        if (puffer < start) {
            puffer = Random.getInteger(start, end);
        }
        return puffer;
    }

}
