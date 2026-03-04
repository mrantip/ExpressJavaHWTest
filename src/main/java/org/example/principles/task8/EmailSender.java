package org.example.principles.task8;

public class EmailSender implements Sendable {
    @Override
    public void send(String message) {
        System.out.println("Отправка email: " + message);
    }
}