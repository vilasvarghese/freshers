package DependencyInversion;

/**
 * Created by iakay on 24.03.2019.
 */
public class DIProblem {
    static class MailService {
        public void sendMail() {
            System.out.println("Hello World! This is mail.");
        }
    }

    static class SMSService {
        public void sendSMS() {
            System.out.println("Hello World! This is sms.");
        }
    }

    static class NotifyCustomer {
        private MailService mailService;
        private SMSService smsService;
        NotifyCustomer(MailService mailService) {
            this.mailService = mailService;
        }

        NotifyCustomer(SMSService smsService) {
            this.smsService = smsService;
        }

        public void notifyCustomer() {
            mailService.sendMail();
        }

        public void notifyCustomerViaSMS() {
            smsService.sendSMS();;
        }
    }

    public static void main(String[] args) {
        MailService mailService = new MailService();
        NotifyCustomer notifyCustomer = new NotifyCustomer(mailService);
        notifyCustomer.notifyCustomer();

        SMSService smsService = new SMSService();
        NotifyCustomer notifyCustomerViaSMS = new NotifyCustomer(smsService);
        notifyCustomerViaSMS.notifyCustomerViaSMS();
    }
}
