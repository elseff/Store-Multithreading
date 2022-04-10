package Store;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Магазин
@Slf4j
public class Store {
    private List<Product> products;

    public Store() {
        products = new ArrayList<>();
    }

    public void getInfoAboutStorage() {
        log.info(String.format("Products on storage (%s) ", products.size()));
        products.forEach(e -> log.info(String.format("%10s(%s), ", e.getName(), e.getPrice())));
        log.info(String.format("sum of prices: %s\n", products.stream().mapToDouble(Product::getPrice).sum()));
    }

    public synchronized void get() throws InterruptedException {
        while (products.size() < 1) {
            wait();
        }
        Product product = products.get(new Random().nextInt(products.size()));
        log.info(String.format("Consumer has bought a %s by %s price\n",
                product.getName(), product.getPrice()));
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
        log.info(String.format("Producer has loaded a %s by %s price\n", product.getName(), product.getPrice()));
        getInfoAboutStorage();
        notify();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

