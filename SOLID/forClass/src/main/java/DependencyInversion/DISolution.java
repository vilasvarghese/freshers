package DependencyInversion;

/**
 * Created by iakay on 24.03.2019.
 */
public class DISolution {
    interface NotifyService {
        void notifyCustomer();
    }
    static class MailService implements NotifyService {

        public void notifyCustomer() {
            System.out.println("Hello World! This is mail.");
        }
    }

    static class SMSService implements NotifyService {

        public void notifyCustomer() {
            System.out.println("Hello World! This is sms.");
        }
    }

    static class NotifyCustomer {
        private NotifyService notifyService;
        NotifyCustomer(NotifyService notifyService) {
            this.notifyService = notifyService;
        }

        public void notifyCustomer() {
            notifyService.notifyCustomer();
        }

    }

    public static void main(String[] args) {
        MailService mailService = new MailService();
        NotifyCustomer notifyCustomerViaMail = new NotifyCustomer(mailService);
        notifyCustomerViaMail.notifyCustomer();

        SMSService smsService = new SMSService();
        NotifyCustomer notifyCustomerViaSms = new NotifyCustomer(smsService);
        notifyCustomerViaSms.notifyCustomer();
    }
}
