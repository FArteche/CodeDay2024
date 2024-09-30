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
    public void enviar(Atraso atraso) {
        // Configurações do servidor
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        // Criar sessão
        Session session = Session.getInstance(props, new Authenticator() {
            //EMAIL QUE VAI FORNECER OS ENVIOS / Necessita de uma passkey gerada pelo gmail
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("jlucacorrea@gmail.com", "senha de app do email responsavel");
            }
        });

        try {
            // Criar mensagem (*Alterar atraso.getFuncionario().getEmail para algum email string para testar)
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("jlucacorrea@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(atraso.getFuncionario().getEmail()));
            message.setSubject("Atraso - Aluno: " + atraso.getAluno().getNome());
            message.setText(" Atraso referente ao aluno " + atraso.getAluno().getNome() +
                    "\n ------------------------" +
                    "\n Data: " + atraso.getData() +
                    "\n Hora: " + atraso.getHora() +
                    "\n Justificativa: " + atraso.getJustificativa()
            );

            // Enviar mensagem
            Transport.send(message);
            System.out.println("Email enviado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}