package batu.hrms.core.serviceAdapters;

import batu.hrms.core.utilities.results.Result;

public interface EmailService {
	void sendMail(String email, String message);
	Result verifyEmail(String email, String verifiCode1, String verifiCode2);
}
