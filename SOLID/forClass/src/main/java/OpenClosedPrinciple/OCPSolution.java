package OpenClosedPrinciple;

/**
 * Created by iakay on 8.03.2019.
 */
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
