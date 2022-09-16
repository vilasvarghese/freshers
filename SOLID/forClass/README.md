# SOLID Principles Tutorial

## Single Responsibility Principle
Definition: A class should have only one reason to change.

Meaning: **ONE FUNCTION/CLASS = ONE RESPONSIBILITY**

**Problem**: We have a message class below that it can prepare, print and send message.

```java
public class SRPProblem {
    static class Message {
        static String messageBody;
        public static void writeMessage(String message) {
            messageBody = message;
            printMessage(messageBody);
        }

        public static void printMessage(String messageBody) {
            System.out.println("Message is : " + messageBody);
        }

        public static void replaceMessageContent(String oldWord, String newWord) {
            messageBody = messageBody.replace(oldWord, newWord);
            printMessage(messageBody);
        }

        public static void sendMessage() {
            System.out.println("Message sent. Content is : " + messageBody);
        }
    }

    public static void main(String[] args) {
        Message.writeMessage("Hello");
        Message.replaceMessageContent("Hello", "Hi");
        Message.sendMessage();
    }
}
```
**Solution** : Each of these futures should be a separate class. 
1. Write message method is one of the future that it can be seperable from others. So it should be a class and we convert it to class.

```java
public static void writeMessage(String message) {
    messageBody = message;
    PrintMessage.printMessage(messageBody);
}
```
Instead of the above, we will use below.
```java
static class WriteMessage {
    static String messageBody;
    public static void writeMessage(String message) {
        messageBody = message;
        PrintMessage.printMessage(messageBody);
    }
}
```
2. Print message method is also one of the future that it can be seperable from others. So it should be also a class and we convert it to class.

```java
public static void printMessage(String messageBody) {
    System.out.println("Message is : " + messageBody);
}
```
Instead of the above, we will use below.
```java
static class PrintMessage {
    public static void printMessage(String messageBody) {
        System.out.println("Message is : " + messageBody);
    }
}
```
3. Send message method is also one of the future that it can be seperable from others. So it should be also a class and we convert it to class.

```java
public static void sendMessage() {
    System.out.println("Message sent. Content is : " + messageBody);
}
```
Instead of the above, we will use below.
```java
static class SendMessage {
    public static void sendMessage(String messageBody) {
        System.out.println("Message sent. Content is : " + messageBody);
    }
}

```

As you will see below, we seperate features to different classes ( write, print, send ) and each class just do it's job for appling single responsibility principle.
```java
public class SRPSolution {
    static class WriteMessage {
        static String messageBody;
        public static void writeMessage(String message) {
            messageBody = message;
            PrintMessage.printMessage(messageBody);
        }

        public static void replaceMessageContent(String oldWord, String newWord) {
            messageBody = messageBody.replace(oldWord, newWord);
            PrintMessage.printMessage(messageBody);
        }
    }

    static class PrintMessage {
        public static void printMessage(String messageBody) {
            System.out.println("Message is : " + messageBody);
        }
    }

    static class SendMessage {
        public static void sendMessage(String messageBody) {
            System.out.println("Message sent. Content is : " + messageBody);
        }
    }

    public static void main(String[] args) {
        WriteMessage.writeMessage("Hello");
        WriteMessage.replaceMessageContent("Hello", "Hi");
        SendMessage.sendMessage(WriteMessage.messageBody);
    }
}
```
Homework: Replace of message future also can be a class, you can apply single responsibility principle at this point.

## Open Close Principle
Definition: Software entities (classes, functions, etc.) should be open for extension, but closed for modification.

Meaning: **FUNCTION/CLASS = :tw-2705: EXTENSION :tw-274e: MODIFICATION**

Problem: We have a notification class below that it can notify customer as sms or mail. If we want to add a new notification type, we have to change our class.
```java
public class OCPProblem {
    enum messageType { SMS, MAIL }
    static class Notification {
        static String messageBody;
        static public void notifyCustomer(messageType type, String messageBody) {
            if (type.equals(messageType.MAIL)) {
                System.out.println("Message sent as mail. Content is : " + messageBody);
            } else if (type.equals(messageType.SMS)) {
                System.out.println("Message sent as sms. Content is : " + messageBody);
            }
        }
    }

    public static void main(String[] args) {
        Notification.notifyCustomer(messageType.MAIL, "Your application has been received.");
        Notification.notifyCustomer(messageType.SMS, "Your application has been received.");
    }
}
```
Solution : So we have to design our class that it should not change when a new notification type added.
1. Firstly, we will create an abstact class for notify.
```java
public static abstract class Notify {
        public abstract void notifyCustomer(String messageBody);
}
```
2. Now we can add sms and mail notification types that they extend our abstract class.
```java
public static class NotificationViaSMS extends Notify {
    public void notifyCustomer(String messageBody) {
        System.out.println("Message sent as sms. Content is : " + messageBody);
    }
}
public static class NotificationViaMail extends Notify {
    public void notifyCustomer(String messageBody) {
        System.out.println("Message sent as mail. Content is : " + messageBody);
    }
}
```
As a result, our code turn to below.
```java
public class OCPSolution {
    static class Notification {
        public static abstract class Notify {
            public abstract void notifyCustomer(String messageBody);
        }

        public static class NotificationViaSMS extends Notify {
            public void notifyCustomer(String messageBody) {
                System.out.println("Message sent as sms. Content is : " + messageBody);
            }
        }

        public static class NotificationViaMail extends Notify {
            public void notifyCustomer(String messageBody) {
                System.out.println("Message sent as mail. Content is : " + messageBody);
            }
        }
    }

    public static void main(String[] args) {
        Notification.NotificationViaMail mail = new Notification.NotificationViaMail();
        Notification.NotificationViaSMS sms = new Notification.NotificationViaSMS();
        mail.notifyCustomer("Your application has been received.");
        sms.notifyCustomer("Your application has been received.");
    }
}
```

After this transformation, we are free for adding new notification types without regression to anywhere.

## Liskov Substitution Principle
Definition: The principle defines that objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.

Meaning: **(Class A extends Class B) = (Class B extends Class A)**

Problem: We have a drink machine class below that it can prepapre drink and adding milk to drink. When we want to drink coffee, machine can preprare it and it can add milk to coffee. If we want to drink tea, it can prepare but it should not add milk to tea. If we check the rule, TeaMachine class can not replaceable with Machine class. So it will throw error when tea machine add milk.
```java
public class LSProblem {
    static class DrinkMachine {
        public static abstract class Machine {
            public static void prepareDrink() {
                System.out.println("prepared.");
            }

            public abstract void addMilk();
        }

        public static class CoffeeMachine extends Machine {

            public void addMilk() {
                System.out.println("milk added.");
            }
        }

        public static class TeaMachine extends Machine {

            public void addMilk(){
                throw new NotImplementedException();
            }
        }
    }

    public static void main(String[] args) {
        DrinkMachine.Machine coffee = new DrinkMachine.CoffeeMachine();
        DrinkMachine.Machine tea = new DrinkMachine.TeaMachine();

        callDrinkMachine(coffee);
        callDrinkMachine(tea);
    }

    public static void callDrinkMachine(DrinkMachine.Machine machine) {
        machine.prepareDrink();
        machine.addMilk();
    }
}
```
1. Machine class has behavior of prepare and property of adding milk. So we have to introduce behavior via another class and properties via an interface.

```java
public static abstract class Machine {
	public static void prepareDrink() {
		System.out.println("prepared.");
	}
}

public static interface IAddMilk {
	void addMilk();
}
```
2. Now we can implement coffee and tea class again.

```java
public static class CoffeeMachine extends Machine implements IAddMilk {
	public void addMilk() {
		System.out.println("milk added.");
	}
}
```
```java
public static class TeaMachine extends Machine {

}
```
3. Our implemantions are finished. We can prepare our drinks.
```java
public static void main(String[] args) {
		DrinkMachine.CoffeeMachine coffee = new DrinkMachine.CoffeeMachine();
		DrinkMachine.Machine tea = new DrinkMachine.TeaMachine();

		coffee.prepareDrink();
		coffee.addMilk();

		tea.prepareDrink();
}
```

You can check the program. TeaMachine and CoffeMachine classes can replace Machine class without breaking the application. Afterall they have similar behavior.

## Interface Segregation Principle
Coming soon...

## Dependency Inversion Principle
Coming soon...


