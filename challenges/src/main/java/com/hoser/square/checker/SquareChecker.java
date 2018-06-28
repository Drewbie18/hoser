package com.hoser.square.checker;

public class SquareChecker {

    private final double[] a;
    private final double[] b;
    private final double[] c;
    private final double[] d;

    public SquareChecker(double[] a, double[] b, double[] c, double[] d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public boolean isASquare(){
        double aDeltaB = cartesianDistance(a,b);
        double aDeltaC =  cartesianDistance(a,c);
        double aDeltaD = cartesianDistance(a,d);

        System.out.println("A to B: " + aDeltaB);
        System.out.println("A to C: " + aDeltaC);
        System.out.println("A to D: " + aDeltaD);

        if(equalDistance(aDeltaB,aDeltaC) &&
                equalDistance(hypotenuse(aDeltaB,aDeltaC),aDeltaD)){
            System.out.println("Square");
            return true;
        }

        if(equalDistance(aDeltaB,aDeltaD) &&
                equalDistance(hypotenuse(aDeltaB,aDeltaB),aDeltaD)){
            System.out.println("Square");
            return true;
        }
        return false;
    }


    private boolean equalDistance(double distanceOne, double distanceTwo){
        return Double.compare(distanceOne,distanceTwo) == 0;
    }

    private double cartesianDistance(double[] pointOne, double[] pointTwo){
        return Math.sqrt((Math.pow(pointTwo[0] - pointOne[0],2) +
                Math.pow(pointTwo[1] - pointOne[1],2)));
    }

    private double hypotenuse(double sideA, double sideB){
        return Math.sqrt(Math.pow(sideA,2)+ Math.pow(sideB, 2));
    }
}
