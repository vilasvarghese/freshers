package LiskovSubstitution;

/**
 * Created by iakay on 18.03.2019.
 */
public class LSSolution {
    static class DrinkMachine {
        public static abstract class Machine {
            public static void prepareDrink() {
                System.out.println("prepared.");
            }
        }

        public static interface IAddMilk {
            void addMilk();
        }

        public static class CoffeeMachine extends Machine implements IAddMilk {

            public void addMilk() {
                System.out.println("milk added.");
            }
        }

        public static class TeaMachine extends Machine {

        }
    }

    public static void main(String[] args) {
        DrinkMachine.CoffeeMachine coffee = new DrinkMachine.CoffeeMachine();
        DrinkMachine.Machine tea = new DrinkMachine.TeaMachine();

        callDrinkMachine(coffee);
        coffee.addMilk();

        callDrinkMachine(tea);
    }

    public static void callDrinkMachine(DrinkMachine.Machine machine) {
        machine.prepareDrink();
    }
}
