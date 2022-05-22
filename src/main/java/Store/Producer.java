package Store;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

//Производитель
@Data
@Slf4j
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Producer extends Thread {
    final Store store;

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            try {
                store.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("\tProduct has been loaded full");
    }
}
