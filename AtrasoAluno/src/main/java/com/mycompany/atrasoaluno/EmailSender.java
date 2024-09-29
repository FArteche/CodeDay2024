package com.mycompany.atrasoaluno;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    public void enviar() {
        // Configurações do servidor
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Criar sessão
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("drivedagaleraoficial@gmail.com", "Drivedagalera123");
            }
        });

        try {
            // Criar mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("drivedagaleraoficial@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jlucacorrea@proton.me"));
            message.setSubject("Assunto da Notificação");
            message.setText("Conteúdo da Notificação");

            // Enviar mensagem
            Transport.send(message);
            System.out.println("Email enviado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
