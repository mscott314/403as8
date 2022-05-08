public class FoodBank {
    int food;

    public FoodBank() {
        this.food = 0;
    }

    public void giveFood(int food) {
        this.food += food;
    }

    public void takeFood(int food) {
        this.food -= food;
    }
}
