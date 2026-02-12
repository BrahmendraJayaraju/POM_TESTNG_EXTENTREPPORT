package Generic;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class SendReportEmail {
	public static String filepath = "/TestEnviornmentSetUp/BasicTestSetUp.properties";

	@Test
	public void sendEmail() throws Exception {

		if (WebUtilityKeys.readPropertyFiles(filepath, "Sanity").equals("Yes".trim())) {
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath("");

			attachment.setDisposition(EmailAttachment.ATTACHMENT);

			attachment.setDescription("Automation sanity Extent Report");
			attachment.setName("Archive.html");

			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			// email.setHostName("smtp-mail.outlook.com");
			// email.setSmtpPort( 587);
			email.setSSLOnConnect(true);
			email.setAuthenticator(new DefaultAuthenticator("", ""));
		
			try {

				email.setFrom("");

				
				email.setSubject("");
				email.setMsg(
						"Hi Team,\n\nplease find attached Sanity automation ExtentReport. Download and open in Chrome Broswer.\n\n\nThanksRegards,\nBrahmendra jayaraju\n9886603727");

				email.addTo("");
				email.addTo("");

			}

			catch (Exception e)

			{

			}

			email.attach(attachment);

			email.send();

		}

		else if (WebUtilityKeys.readPropertyFiles(filepath, "Regression").equals("Yes".trim()))

		{

			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath("");
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Automation Regression Extent Report");
			attachment.setName("Archive.html");

			// Create the email message
			MultiPartEmail email = new MultiPartEmail();
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			// email.setHostName("10.38.9.235");

			// email.setSmtpPort(25);

			email.setSSLOnConnect(true);
			email.setAuthenticator(new DefaultAuthenticator("", ""));
			
			try {
				email.setFrom("");
			
				email.setSubject("ExecutionReport");
				email.setMsg(
						"Hi Team,\n\nplease find attached Regression automation ExtentReport. Download and  open in Chrome Broswer.\n\n\nThanksRegards,\nBrahmendra jayaraju\n9886603727");

				email.addTo("");
				email.addTo("");

			}

			catch (Exception e)

			{

				;

			}

			email.attach(attachment);

			email.send();

		}

	}

}
