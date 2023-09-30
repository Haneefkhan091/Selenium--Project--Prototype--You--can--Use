package OTPAuthentication;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import javax.mail.Store;

import com.testing.framework.EmailUtils;
//import com.testing.framework.EmailUtils;

public class OTPAuthentication {
	public static void main(String[] args) throws Exception {
// TODO Auto-generated method stub
//		EmailUtils emailUtils = new EmailUtils();
		EmailUtils emailUtils = new EmailUtils();
		Properties prop = new Properties();
		prop.setProperty("to", "HaneefUllah00345@gmail.com");
		prop.setProperty("gmail_from", "HaneefUllah00345@gmail.com");
		prop.setProperty("gmail_username", "HaneefUllah00345@gmail.com");
		prop.setProperty("gmail_password", "doumzzzgyfoeyupw");
		prop.setProperty("gmail_port", "587");
		//Store connection = emailUtils.connectToGmail(prop);
//emailUtils.getUnreadMessages (connection, "Inbox");
		@SuppressWarnings("unchecked")
		List<String> emailtext = emailUtils.getUnreadMessageByFromEmail(emailUtils.connectToGmail(prop),"Inbox","contact@immo-experte24.ch","Email Verification");
		if (emailtext.size() < 1)
			throw new Exception("No Email recieved");
		else {
			String regex="[^\\d]+";
			String[] arrOTP=emailtext.get(1).split(regex);
			String OTP = arrOTP[1];
			System.out.println("OTP is "+OTP);
		}
	}
}