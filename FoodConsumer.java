import java.util.Random;
import java.util.concurrent.Semaphore;

public class FoodConsumer extends Thread {
    FoodBank bank;

    public FoodConsumer(FoodBank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            Semaphore sem = new Semaphore(1);
            Random r = new Random();

            sleep(100);

            while (true) {
                int random_number = r.nextInt(101);
                sem.acquire();
                while ((bank.food - random_number) < 0 || bank.food < 0) {
                    System.out.println("Waiting to get food (tried taking " + random_number + ")");
                    sleep(100);
                }
                sem.release();
                bank.takeFood(random_number);
                System.out.print("Taking " + random_number + " items of food, ");
                System.out.println("the balance is now " + bank.food + " items.");
                sleep(100);
            }
        } catch (InterruptedException e) {
        }
    }
}