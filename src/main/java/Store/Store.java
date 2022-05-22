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
        log.debug("Products on storage ({}) ", products.size());
        products.forEach(e -> log.info("{} ({}), ", e.getName(), e.getPrice()));
        double sumOfPrices = products.stream().mapToDouble(Product::getPrice).sum();
        log.debug("sum of prices: {}\n", sumOfPrices);
    }

    public synchronized void get() throws InterruptedException {
        while (products.size() < 1) {
            wait();
        }
        Product product = products.get(new Random().nextInt(products.size()));
        log.info("Consumer has bought a {} by {} price\n",
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
        log.info("Producer has loaded a {} by {} price\n", product.getName(), product.getPrice());
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

