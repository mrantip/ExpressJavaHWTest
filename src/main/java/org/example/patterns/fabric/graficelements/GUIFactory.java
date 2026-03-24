package org.example.patterns.fabric.graficelements;

public interface GUIFactory {
    Button createButton();
    Menu createMenu();
    Window createWindow();
}