package Store;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

//Потребитель
@Slf4j
@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Consumer extends Thread {
    Store store;

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
