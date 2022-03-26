package Store;

//Производитель
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
        System.out.println("\tProduct has been loaded full");
    }
}
