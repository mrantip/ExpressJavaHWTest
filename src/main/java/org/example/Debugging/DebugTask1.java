package org.example.Debugging;

public class DebugTask1 {
    public static void main(String[] args) {
        //Убираем знак = в этом месте i < numbers.length
        int[] numbers = {10, 20, 30, 40, 50};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}