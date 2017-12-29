package studypro;

import java.lang.Object;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.Resource;
import studypro.ContactEntity;
import studypro.ContactTelDetailEntity;
import studypro.HobbyEntity;
import studypro.ContactService;

import java.util.List;


public class Main {

    public static void main(String[] args) {
        System.out.println("starting application...");
        System.out.println("creating GenericXmlApplicationContext");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        System.out.println("ctx created");
        System.out.println("loading spring-config.xml");
        ctx.load("classpath:spring-config.xml");
        System.out.println("loaded");
        System.out.println("refreshing");
        ctx.refresh();
        System.out.println("refreshed");
        System.out.println("getting contactService bean from context...");
        ContactService contactService = ctx.getBean("jpaContactService", ContactService.class);
        System.out.println("trying to contactService.findAll()");
        List<ContactEntity> contacts = contactService.findAll();
        printAll(contacts);
        System.out.println("trying to contactService.findAllWithDetail()");
        List<ContactEntity> cotactsWithDetail = contactService.findAllWithDetail();
        testContactDetail(cotactsWithDetail);
        System.out.println("ending application...");
    }

    private static void printAll(List<ContactEntity> contacts) {
        System.out.println(String.format("JPA tutorial. Contact (size %s)", contacts.size()));
        for (ContactEntity contact : contacts) {
            System.out.println(contact);
        }
    }

    private static void testContactDetail(List<ContactEntity> contacts) {
        System.out.println(String.format("Contact with detail (size %s)", contacts.size()));
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