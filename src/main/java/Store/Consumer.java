package Store;
/**
 * Consumer can buy a product if he there is on the shop storage,
 * if on shop storage there isn't a products, Consumer will wait.
 */
public class Consumer extends Thread{
    Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                store.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\tAll products has been bought");
    }
}
