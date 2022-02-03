package InterfaceSegregation;

/**
 * Created by iakay on 22.03.2019.
 */
public class ISProblem {

    interface DrinkMachine {
        void prepareCoffee();
        void prepareTea();
    }

    static class DrinkMachineImpl implements DrinkMachine {

        public void prepareCoffee() {
            System.out.println("make coffee");
        }

        public void prepareTea() {
            System.out.println("make tea");
        }
    }

    static class TeaMachineImpl implements DrinkMachine {

        public void prepareCoffee() {
            // nothing
        }

        public void prepareTea() {
            System.out.println("make tea");
        }
    }

    public static void main(String[] args) {
        DrinkMachine machine = new DrinkMachineImpl();
        machine.prepareCoffee();
        machine.prepareTea();

        DrinkMachine teaMachine = new TeaMachineImpl();
        teaMachine.prepareTea();
    }
}
