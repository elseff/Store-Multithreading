package Store;

import lombok.extern.slf4j.Slf4j;

/**
 * Consumer can buy a product if he there is on the shop storage,
 * if on shop storage there isn't a products, Consumer will wait.
 */
@Slf4j
public class Consumer extends Thread {
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
        log.info("All products has been bought");
    }
}
