package org.example;

public class DebugTask8 {
    public static void main(String[] args) {
        //для double может быть слишком много цифер после запятой. поменял тип данных на float
        float a = (float) 0.1 * 3;
        float b = 0.3F;
        if (a == b) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}