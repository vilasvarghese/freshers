package SingleResponsibilityPrinciple;

/**
 * Created by iakay on 8.03.2019.
 */
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
