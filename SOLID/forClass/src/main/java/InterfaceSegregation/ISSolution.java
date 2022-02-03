package InterfaceSegregation;

/**
 * Created by iakay on 22.03.2019.
 */
public class ISSolution {

    interface TeaMachine {
        void prepareTea();
    }

    interface CoffeMachine {
        void prepareCoffee();
    }

    static class DrinkMachineImpl implements CoffeMachine, TeaMachine {

        public void prepareCoffee() {
            System.out.println("make coffee");
        }

        public void prepareTea() {
            System.out.println("make tea");
        }
    }

    static class TeaMachineImpl implements TeaMachine {

        public void prepareTea() {
            System.out.println("make tea");
        }
    }

    public static void main(String[] args) {
        DrinkMachineImpl machine = new DrinkMachineImpl();
        machine.prepareCoffee();
        machine.prepareTea();

        TeaMachine teaMachine = new TeaMachineImpl();
        teaMachine.prepareTea();
    }
}
