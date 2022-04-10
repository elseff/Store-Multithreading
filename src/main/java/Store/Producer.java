package Store;

import lombok.extern.slf4j.Slf4j;

/**
 * Producer can load the product to store
 * if on the shop storage there is the place(3),
 * otherwise Producer will wait.
 */
@Slf4j
public class Producer extends Thread {
    Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                store.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        log.info("Product has been loaded full");
    }
}
