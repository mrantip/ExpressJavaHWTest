package org.example.Debugging;

public class DebugTask7 {
    //потоки одновременно проверяли баланс и проходили проверку. Добавил синхронизацию и сообщение при невозможности извлечь
    private static int balance = 100;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> withdraw(60));
        Thread t2 = new Thread(() -> withdraw(50));
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
    public static synchronized void withdraw(int amount) {
        if (balance >= amount) {
            try { Thread.sleep(100); } catch (InterruptedException e) { }
            balance -= amount;
            System.out.println("New balance: " + balance);
        } else {
            System.out.println("Недостаточно средств. Нельзя извлечь " + amount);
        }
    }
}