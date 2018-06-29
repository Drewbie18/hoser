package com.hoser.square.checker.test;

import com.hoser.square.checker.SquareChecker;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SquareCheckerTests {
    @Test
    public void isSquare(){
        double[] pointA = new double[]{10,20};
        double[] pointB = new double[]{20,20};
        double[] pointC = new double[]{10,10};
        double[] pointD = new double[]{20,10};
        SquareChecker squareChecker = new SquareChecker(pointA,pointB,pointC,pointD);
        assertTrue(squareChecker.isASquare());
    }

    @Test
    public void isNotSquare(){
        double[] pointA = new double[]{10,15};
        double[] pointB = new double[]{20,20};
        double[] pointC = new double[]{10,10};
        double[] pointD = new double[]{20,10};
        SquareChecker squareChecker = new SquareChecker(pointA,pointB,pointC,pointD);
        assertFalse(squareChecker.isASquare());
    }
}
