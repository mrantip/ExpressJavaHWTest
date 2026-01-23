package org.example.Debugging;

public class DebugTask5 {
    public static void main(String[] args) {
        //метод updateAge создавал новый объект класса Person с возрастом +1.
        // Новый обект не нужен. Добавил сеттер и изменил метод updateAge для измененения возраста
        Person person = new Person("Alice", 25);
        updateAge(person);
        System.out.println("Updated age: " + person.getAge());
    }

    public static void updateAge(Person person) {
        int newAge = person.getAge() + 1;
        person.setAge(newAge);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }
}