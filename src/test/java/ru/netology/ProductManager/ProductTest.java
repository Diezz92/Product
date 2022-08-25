package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProductTest {

    ProductRepository productRepository = new ProductRepository();
    Manager manager = new Manager(productRepository);
    Book book1 = new Book(1, "Алиса в репозитории", 100, "Алиса");
    Book book2 = new Book(10, "Гарри Поттер и распредвал", 200, "Джоан Роулинг");
    Smartphone smartphone1 = new Smartphone(5, "Samsung", 15_000, "Japan");
    Smartphone smartphone2 = new Smartphone(7, "Xiaomi", 10_000, "China");

       @BeforeEach
        public void setup () {
            manager.add(book1);
            manager.add(book2);
            manager.add(smartphone1);
            manager.add(smartphone2);
        }


    @Test

    public void SearchByName() {

        Product[] actual = manager.searchBy("Алиса");
        Product[] expected = {book1};

        Assertions.assertArrayEquals(expected, actual);
    }

   @Test

   public void AllInProduct() {

       Product[] actual = manager.findAll();
       Product[] expected = { book1, book2, smartphone1, smartphone2 };

       Assertions.assertArrayEquals(expected, actual);
   }

    @Test

    public void RemoveId() {

           manager.repo.removeId(smartphone1.getId());

        Product[] actual = manager.findAll();
        Product[] expected = { book1, book2, smartphone2 };

        Assertions.assertArrayEquals(expected, actual);
    }
}
