package app;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Solution_02 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scaner = new Scanner(System.in);
        int[] array = new int[15];

        for (int i = 0; i < array.length ; i++) {
            array[i] = random.nextInt(100) + 1;
        }
        System.out.println("Початковий вигляд масиву: " + Arrays.toString(array));

        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
        System.out.println("Відсортований масив: " + Arrays.toString(array));
        System.out.println();

        System.out.println("Введіть число від 1 до 100 для пошуку в масиві:");
        int manual = scaner.nextInt();
        int left = 0;
        int right = array.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = left+(right - left) / 2;
            if (array[mid] == manual) {
                index = mid;
                System.out.println("Індекс числа " + manual + " у відсортованому масиві: " + index);
                break;
            }
            else if (array[mid] < manual) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        if (index<0){
            System.out.println("Ваше число в масиві не знайдено.");
        }
    }
}
