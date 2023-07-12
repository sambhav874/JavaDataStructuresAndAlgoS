package Algorithms;

public class TimeComplexityComparison {

    public static double factorial(double a){

        double fact=1;
        if(a==1||a==0){
            return 1;
        }
        else{
            for(double i=1;i<=a;i++){
                fact=fact*i;
            }
            return fact;
        }
    }
    public static void comparingComplexities(double n){
        System.out.println("Values for different complexities: "+n);
        System.out.println("O(1) = "+1);
        System.out.println("O(n) = "+n);
        System.out.println("O(sqrt(n) = "+Math.sqrt(n));
        System.out.println("O(log n) = "+Math.log(n));
        System.out.println("O(log(log n)) = "+Math.log(Math.log(n)));
        System.out.println("O(n log n) = "+n*Math.log(n));
        System.out.println("O(n^2) = "+Math.pow(n, 2));
        System.out.println("O(n^3) = "+Math.pow(n, 3));
        System.out.println("O(2^n) = "+Math.pow(2,n));
        System.out.println("O(e^n) = "+Math.exp(n));
        System.out.println("O(n!) = "+factorial(n));
    }
    public static void main(String[] args) {
        comparingComplexities(10);
        System.out.println("-------------------------------");
        comparingComplexities(100);
        //Try out with different values of n
    }
}
