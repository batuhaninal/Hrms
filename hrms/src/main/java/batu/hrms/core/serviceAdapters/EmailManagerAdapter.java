package batu.hrms.core.serviceAdapters;

import org.springframework.stereotype.Service;

import batu.hrms.core.utilities.results.Result;
import batu.hrms.fakeServices.FakeMailManager;

@Service
public class EmailManagerAdapter implements EmailService {
	
	FakeMailManager mail = new FakeMailManager();

	@Override
	public void sendMail(String email, String message) {
		mail.sendMail(email,message);
	}

	@Override
	public Result verifyEmail(String email, String verifiCode1, String verifiCode2) {
		return mail.verifyMail(email, verifiCode1, verifiCode2);
	}

}
