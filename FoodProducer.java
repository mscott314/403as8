import java.util.Random;
import java.util.concurrent.Semaphore;

public class FoodProducer extends Thread {
    FoodBank bank;

    public FoodProducer(FoodBank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        try {
            Random r = new Random();

            while (true) {
                int random_number = r.nextInt(101);
                bank.giveFood(random_number);
                System.out.print("Giving " + random_number + " items of food, ");
                System.out.println("the balance is now " + bank.food + " items.");
                sleep(100);
            }
        } catch (InterruptedException e) {
        }
    }
}
