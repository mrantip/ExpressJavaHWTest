package org.example.ComplexTasks.task_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class InventoryService {
    private final Map<String, CopyOnWriteArrayList<Product>> inventory = new ConcurrentHashMap<>();
    private boolean inventoryIsOpen = true;

    public void setInventoryIsOpen(boolean open) {
        this.inventoryIsOpen = open;
    }

    public synchronized void addProduct(Product product) {
        if (!inventoryIsOpen) return;
        inventory.computeIfAbsent(product.getCategory(), k -> new CopyOnWriteArrayList<>()).add(product);
    }

    public synchronized Product getProductByCategory(String category) {
        CopyOnWriteArrayList<Product> products = inventory.get(category);
        if (products == null || products.isEmpty()) {
            throw new OutOfStockException("Товары в категории " + category + " отсутствуют.");
        }
        return products.remove(0);
    }

    public List<Product> filterByPrice(double minPrice) {
        return inventory.values().stream()
                .flatMap(List::stream)
                .filter(p -> p.getPrice() >= minPrice)
                .collect(Collectors.toList());
    }

    public List<Product> getAllProductsByCategory(String category) {
        List<Product> products = inventory.get(category);
        return products != null ? new ArrayList<>(products) : List.of();
    }
}