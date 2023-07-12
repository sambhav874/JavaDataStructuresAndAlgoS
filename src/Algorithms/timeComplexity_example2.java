package Algorithms;

public class timeComplexity_example2 {

    public static int calculateGCD(int num1, int num2) {
        int temp;
        if (num1%num2 ==0)
            return num2;
        if (num1 < num2) {
            temp=num1;
            num1=num2;
            num2=temp;
        }
        while (num2 > 0) {
            num1 = num1%num2;
            temp=num1;
            num1=num2;
            num2=temp;
        }
        return num1;
    }
//Initialization of variables: temp - This step takes constant time, O(1).
//First if condition: num1 % num2 == 0 - This step takes constant time, O(1).
//Second if condition: num1 < num2 - This step takes constant time, O(1).
//Swapping values of num1 and num2: This step takes constant time, O(1).
//While loop: This loop iterates until num2 becomes 0. The number of iterations depends on the magnitude of num2 and its effect on num1 during each iteration.
//Inside the while loop:
//Modulo operation: num1 = num1 % num2 - This step takes constant time, O(1).
//Swapping values of num1 and num2: This step takes constant time, O(1).

    //In the worst case, the Euclidean algorithm (used to calculate GCD) performs O(log min(num1, num2)) iterations.
    // This occurs when num1 and num2 are relatively prime, resulting in the maximum number of iterations to reach the GCD of 1.

    //Hence, the overall time complexity of the calculateGCD() method is O(log min(num1, num2)).
}
