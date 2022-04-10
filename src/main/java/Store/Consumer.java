package Store;

import lombok.extern.slf4j.Slf4j;

//Потребитель
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
