package org.example;

import java.util.*;

public class DebugTask10 {
    public static void main(String[] args) {
        //ConcurrentModificationException возникает при изменении коллекции во время её итерации.
        //создал список для удаления. а потом удалил этот список из исходного
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie"));
        List<String> toRemove = new ArrayList<>();
        for (String name : names) {
            if (name.startsWith("A")) {
                toRemove.add(name);
            }
        }
        names.removeAll(toRemove);
    }
}