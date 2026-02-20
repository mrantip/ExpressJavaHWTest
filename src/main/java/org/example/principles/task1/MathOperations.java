package org.example.principles.task1;

public class MathOperations {
    public int add(int... numbers) {
        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }
        return sum;
    }
}