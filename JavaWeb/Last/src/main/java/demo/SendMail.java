package demo;

import com.sun.mail.util.MailSSLSocketFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class SendMail extends Thread {
  private static final String fromEmailAddress = "utsuko27@qq.com";
  private static final String toEmailAddress = "utsuko27@163.com";
  private static final String password = "授权码";
  private final User user;

  public SendMail(User user) {
    this.user = user;
  }

  @Override
  public void run() {
    try {
      Session session = Session.getDefaultInstance(getProperties(), new Authenticator() {
        @Override
        protected PasswordAuthentication getPasswordAuthentication() {
          return new PasswordAuthentication(fromEmailAddress, password);
        }
      });
      session.setDebug(true);

      MimeMessage message = getMimeMessage(session);

      send(session, message);
    } catch (Exception e) {
      System.out.println(e);
    }
  }


  private Properties getProperties() throws GeneralSecurityException {
    Properties prop = new Properties();
    prop.setProperty("mail.host", "smtp.qq.com");///设置QQ邮件服务器
    prop.setProperty("mail.transport.protocol", "smtp");///邮件发送协议
    prop.setProperty("mail.smtp.auth", "true");//需要验证用户密码
    //QQ邮箱需要设置SSL加密
    MailSSLSocketFactory sf = new MailSSLSocketFactory();
    sf.setTrustAllHosts(true);
    prop.put("mail.smtp.ssl.enable", "true");
    prop.put("mail.smtp.ssl.socketFactory", sf);
    return prop;
  }

  private MimeMessage getMimeMessage(Session session) throws MessagingException {
    MimeMessage message = new MimeMessage(session);
    //指明邮件的发件人
    message.setFrom(new InternetAddress(fromEmailAddress));
    //指明邮件的收件人
    message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmailAddress));
    //邮件标题
    message.setSubject("注册通知");
    //邮件的文本内容
    message.setContent(("恭喜你(" + user.getUserName() + ")成功注册！" + "密码：" + user.getPassword())
        , "text/html;charset=UTF-8");
    return message;
  }

  private void send(Session session, MimeMessage message) throws MessagingException {
    Transport transport = session.getTransport();
    transport.connect("smtp.qq.com", fromEmailAddress, password);
    transport.sendMessage(message, message.getAllRecipients());
    transport.close();
  }
}
