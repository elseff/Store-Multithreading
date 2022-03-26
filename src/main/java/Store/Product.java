package Store;

public class Product {
    private String name;
    private float price;

    public Product(String name, float count) {
        this.name = name;
        this.price = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
