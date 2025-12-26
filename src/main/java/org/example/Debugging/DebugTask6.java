package org.example.Debugging;

public class DebugTask6 {
    public static void main(String[] args) {
        countdown(5);
    }

    public static void countdown(int n) {
        //метод вызывал сам себя бесконечно. Нет условия выхода из программы
        //добавил while и умененьшение n
        while (n >= 1) {
            System.out.println(n);
            n--;
        }
    }
}