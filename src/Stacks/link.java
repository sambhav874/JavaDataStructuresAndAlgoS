package Stacks;

import java.util.LinkedList;
import java.util.Scanner;

public class link {
    public static void main(String[] args) {

        LinkedList<Integer> li1 = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes you want to create:");
        int d1= sc.nextInt();
        for (int i = 0; i < d1; i++) {
            System.out.println("Enter the elements.");
            int data = sc.nextInt();
            li1.add(data);
        }
        System.out.println("The list looks like:");
        System.out.println(li1);
    }




    }
