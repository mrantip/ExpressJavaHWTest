package ComplexTasksTests.task_5_tests;

import org.example.ComplexTasks.task_5.InventoryService;
import org.example.ComplexTasks.task_5.OutOfStockException;
import org.example.ComplexTasks.task_5.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InventoryServiceTest {

    @Test
    @DisplayName("Проверка добавления и извлечения товара")
    public void addAndRetrieveProductTest() {
        InventoryService service = new InventoryService();
        Product bunny = new Product("Bunny", 99.99, "Toys");
        service.addProduct(bunny);
        Product retrieved = service.getProductByCategory("Toys");
        assertEquals("Bunny", retrieved.getName());
    }

    @Test
    @DisplayName("Проверка добавления товара в закрытый инвентарь")
    public void addProductWhenInventoryIsClosedTest() {
        InventoryService service = new InventoryService();
        Product bunny = new Product("Bunny", 99.99, "Toys");
        service.setInventoryIsOpen(false);
        service.addProduct(bunny);
        assertThrows(OutOfStockException.class, () -> service.getProductByCategory("Toys"));
    }

    @Test
    @DisplayName("Проверка получения товара из пустого инвентаря")
    public void outOfStockTest() {
        InventoryService service = new InventoryService();
        assertThrows(OutOfStockException.class, () -> service.getProductByCategory("Toys"));
    }

    @Test
    @DisplayName("Проверка фильтра по цене")
    public void filterByPriceTest() {
        InventoryService service = new InventoryService();
        Product bunny = new Product("Bunny", 1000, "Toys");
        Product book = new Product("Book", 100, "Books");
        service.addProduct(bunny);
        service.addProduct(book);
        List<Product> filteredPrice = service.filterByPrice(100.01);
        assertEquals(1, filteredPrice.size());
        assertEquals("Bunny", filteredPrice.get(0).getName());
    }

    @Test
    @DisplayName("Проверка получения всех продуктов по категории")
    public void getAllByCategoryTest() {
        InventoryService service = new InventoryService();
        Product bunny = new Product("Bunny", 1000, "Toys");
        Product star = new Product("Star", 10, "Toys");
        Product book = new Product("Book", 100, "Books");
        service.addProduct(bunny);
        service.addProduct(book);
        service.addProduct(star);
        assertEquals(2, service.getAllProductsByCategory("Toys").size());
    }
}