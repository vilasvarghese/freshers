package OpenClosedPrinciple;

/**
 * Created by iakay on 8.03.2019.
 */
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
