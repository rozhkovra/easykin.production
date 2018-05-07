package ru.rrozhkov.easykin.email;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by rrozhkov on 03.05.2018.
 */
public class EmailServiceTest {
    @Test
    public void testSendMail() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("email-context.xml");
        assertNotNull(context);

        EmailService emailService = (EmailService) context.getBean("emailService");
        assertNotNull(emailService);

        emailService.sendMail("from@no-spam.com",
                "to@no-spam.com",
                "Testing123",
                "Testing only \n\n Hello Spring Email Sender");
    }
}
