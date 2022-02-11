package org.iesfm.airline.email;


import org.iesfm.airline.Email;
import org.iesfm.airline.Flight;
import org.iesfm.airline.Passenger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;



public class EmailListener {
    private final static Logger log = LoggerFactory.getLogger(EmailListener.class);

    private Flight flight;
    private Passenger passenger;

    private JavaMailSender mailSender;

    public EmailListener(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @JmsListener(destination = "airline_email")
    public void onMessage(Email email) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("iesfmpruebas@gmail.com");
        message.setTo("iesfmpruebas@gmail.com");
        message.setSubject("Bienvenido a bordo del vuelo " + flight.getId());
        message.setText("Bienvenido " +passenger.getName()+ " " +passenger.getSurname()+ ", \n" +
                "tu vuelo saldrá el día " +flight.getDate()+ " desde " +flight.getOrigin()+
                " a " +flight.getDestiny()+ ". Tu asiento es " +passenger.getSeat()+ "\n" +
                "No lo pierdas! \n" + "Hasta pronto.");

        mailSender.send(message);
    }

}
