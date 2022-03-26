package Store;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        producer.start();
        consumer.start();
    }
}
