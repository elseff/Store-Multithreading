package Store;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

//Потребитель
@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
public class Consumer extends Thread {
    final Store store;

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
