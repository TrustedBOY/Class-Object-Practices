package EmployeeSalary;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        bubbleSort();
        String[] list = {"D", "A", "G", "B", "E", "F", "C", "H"};

        int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Scanner sc = new Scanner(System.in);
        String hi = sc.nextLine();

//        for (int i = 0; i < list.length; i++) {
//            sortRecursively(list, i);
//        }

        sortFirstLoop(list , 0);

        for (int i = 0; i < list.length; i++) {
            System.out.printf("%s  ", list[i]);
        }

        System.out.println(binarySearchRecursively(digits , 6 , 0,digits.length - 1));
    }

    private static void sortFirstLoop(String[] list ,int i){
        if (i < list.length){
            sortRecursively(list, i);
            sortFirstLoop(list, i+1);
        }
    }
    private static void sortRecursively(String[] list , int index) {
        if (list.length <=1) return;

        if (index < list.length-1){
            if (list[index].compareTo(list[index+1]) > 0) {
                String temp = list[index];
                list[index] = list[index + 1];
                list[index + 1] = temp;
            }
            sortRecursively(list, index+1);
        }
    }

    private static int binarySearchRecursively(int[] list , int target, int low, int high) {
        if (low > high) return 0;

        int mid = (low+high) / 2;

        if (list[mid] < target)
            return binarySearchRecursively(list, target, mid +1, high);
        else if (list[mid] > target)
            return binarySearchRecursively(list, target, low, mid -1);
        else
            return mid;

    }

    private static void bubbleSort(){
        int[] list = {10,2,3,4,5,1,2,311};
        for (int i = 0; i < list.length-1; i++) {
            for (int j = 0; j < list.length-i-1; j++) {
                if (list[j] > list[j+1]) {
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}