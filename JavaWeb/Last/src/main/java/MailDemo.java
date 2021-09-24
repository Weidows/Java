import com.sun.mail.util.MailSSLSocketFactory;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.GeneralSecurityException;
import java.util.Properties;

public class MailDemo {
  private static final String fromEmailAddress = "utsuko27@qq.com";
  private static final String toEmailAddress = "utsuko27@163.com";
  private static final String password = "ixookcbmazeqdcgd";

  public static void main(String[] args) throws Exception {
    //0. 设置连接配置
    Properties properties = getProperties();

    //1.创建定义整个应用程序所需要的环境信息的session对象
    Session session = Session.getDefaultInstance(properties, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(fromEmailAddress, password);
      }
    });
    //开启session的debug模式，这样可以查看到程序发送Email的运行状态
    session.setDebug(true);

    //2.通过session得到transport对象
    Transport transport = session.getTransport();

    //3.使用邮箱的用户名和授权码连上邮件服务器
    transport.connect("smtp.qq.com", fromEmailAddress, password);

    //4.创建邮件：写文件
    // MimeMessage message = getMimeMessage1(session);
    MimeMessage message = getMimeMessage2(session);

    //5.发送邮件
    transport.sendMessage(message, message.getAllRecipients());

    //6.关闭连接
    transport.close();
  }


  private static Properties getProperties() throws GeneralSecurityException {
    Properties properties = new Properties();
    properties.setProperty("mail.host", "smtp.qq.com");///设置QQ邮件服务器
    properties.setProperty("mail.transport.protocol", "smtp");///邮件发送协议
    properties.setProperty("mail.smtp.auth", "true");//需要验证用户密码
    //设置SSL加密(QQ邮箱需要)
    MailSSLSocketFactory mailSSLSocketFactory = new MailSSLSocketFactory();
    mailSSLSocketFactory.setTrustAllHosts(true);
    properties.put("mail.smtp.ssl.enable", "true");
    properties.put("mail.smtp.ssl.socketFactory", mailSSLSocketFactory);
    return properties;
  }

  /**
   * 纯文本数据
   *
   * @param session
   * @return
   * @throws MessagingException
   */
  private static MimeMessage getMimeMessage1(Session session) throws MessagingException {
    MimeMessage message = new MimeMessage(session);
    //指明邮件的发件人
    message.setFrom(new InternetAddress(fromEmailAddress));
    //指明邮件的收件人
    message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmailAddress));
    //邮件标题
    message.setSubject("发送的标题");

    //邮件的文本内容
    message.setContent("内容", "text/html;charset=UTF-8");
    return message;
  }

  /**
   * 含带附件的邮件
   *
   * @param session
   * @return
   * @throws MessagingException
   */
  private static MimeMessage getMimeMessage2(Session session) throws MessagingException {
    MimeMessage message = new MimeMessage(session);
    //指明邮件的发件人
    message.setFrom(new InternetAddress(fromEmailAddress));
    //指明邮件的收件人
    message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmailAddress));
    //邮件标题
    message.setSubject("发送的标题");

    //邮件的文本内容
    //=================================准备图片数据
    MimeBodyPart image = new MimeBodyPart();
    //图片需要经过数据化的处理
    DataHandler dataHandler = new DataHandler(new FileDataSource("D:/Game/Weidows/JavaWeb/Last/src/main/java/MailDemo.java"));
    //在part中放入这个处理过图片的数据
    image.setDataHandler(dataHandler);
    //给这个part设置一个ID名字
    image.setContentID("嵌入.png");

    //=================================准备正文数据
    MimeBodyPart text = new MimeBodyPart();
    text.setContent("这是一张正文<img src='嵌入.jpg'>", "text/html;charset=UTF-8");

    //=================================准备附件数据
    MimeBodyPart body = new MimeBodyPart();
    body.setDataHandler(new DataHandler(new FileDataSource("D:/Game/Weidows/JavaWeb/Last/src/main/java/MailDemo.java")));
    body.setFileName("附件.png");

    //描述数据关系
    MimeMultipart mimeMultipart = new MimeMultipart();
    mimeMultipart.addBodyPart(image);
    mimeMultipart.addBodyPart(text);
    mimeMultipart.addBodyPart(body);
    mimeMultipart.setSubType("mixed");

    //设置到消息中，保存修改
    message.setContent(mimeMultipart);
    message.saveChanges();
    return message;
  }

}
