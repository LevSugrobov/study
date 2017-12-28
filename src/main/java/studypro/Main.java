package studypro;



import org.springframework.context.support.GenericXmlApplicationContext;
import studypro.ContactEntity;
import studypro.ContactTelDetailEntity;
import studypro.HobbyEntity;
import studypro.ContactService;

import java.util.List;



public class Main {

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring-config.xml");
        ctx.refresh();

        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);

        List<ContactEntity> contacts = contactService.findAll();
        printAll(contacts);

        List<ContactEntity> cotactsWithDetail = contactService.findAllWithDetail();
        testContactDetail(cotactsWithDetail);
    }

    private static void printAll(List<ContactEntity> contacts) {
        System.out.println("JPA tutorial. Contact");
        for (ContactEntity contact : contacts) {
            System.out.println(contact);
        }
    }

    private static void testContactDetail(List<ContactEntity> contacts) {
        System.out.println("Contact with detail");
        for (ContactEntity contact : contacts) {
            System.out.println("Contact: ");
            System.out.println(contact);
            if (contact.getContactTelDetails() != null) {
                for (ContactTelDetailEntity tel : contact.getContactTelDetails()) {
                    System.out.println("Details: ");
                    System.out.println(tel);
                }
            }

            System.out.println("Hobby: ");
            if (contact.getHobbies() != null) {
                for (HobbyEntity hobby : contact.getHobbies()) {
                    System.out.println(hobby);
                }
            }
        }
    }

}