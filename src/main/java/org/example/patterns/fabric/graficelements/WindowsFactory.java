package org.example.patterns.fabric.graficelements;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }

    @Override
    public Window createWindow() {
        return new WindowsWindow();
    }
}