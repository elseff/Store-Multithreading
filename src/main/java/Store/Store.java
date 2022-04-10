package Store;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Магазин
@Slf4j
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Store {
    List<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public void getInfoAboutStorage() {
        System.out.printf("Products on storage (%s) ", products.size());
        products.forEach(e -> System.out.printf("%s(%s), ", e.getName(), e.getPrice()));
        System.out.print(" - sum of prices: " + products.stream().mapToDouble(Product::getPrice).sum() + "\n\n");
    }

    public synchronized void get() throws InterruptedException {
        while (products.size() < 1) {
            wait();
        }
        Product product = products.get(new Random().nextInt(products.size()));
        System.out.printf("\tConsumer has bought a %s by %s price\n",
                product.getName(), product.getPrice());
        products.remove(product);
        getInfoAboutStorage();
        notify();
    }

    public synchronized void put() throws InterruptedException {
        while (products.size() >= 3) {
            wait();
        }
        Product product = new Product(NamesOfProducts.values()[new Random().
                nextInt(NamesOfProducts.values().length)].name(), new Random().nextInt(100) + 100);
        products.add(product);
        System.out.printf("\tProducer has loaded a %s by %s price\n", product.getName(), product.getPrice());
        getInfoAboutStorage();
        notify();
    }
}

