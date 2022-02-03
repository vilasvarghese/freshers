package SingleResponsibilityPrinciple;

/**
 * Created by iakay on 8.03.2019.
 */
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
