package org.example.patterns.fabric.graficelements;

public class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Menu createMenu() {
        return new MacMenu();
    }

    @Override
    public Window createWindow() {
        return new MacWindow();
    }
}