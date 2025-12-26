package org.example.Debugging;

public class DebugTask3 {
    public static void main(String[] args) {
        //значение i не менялось после каждой итерации. добавил i++
        int i = 1;
        while (i <= 5) {
            System.out.println("Number: " + i);
            i++;
        }
    }
}