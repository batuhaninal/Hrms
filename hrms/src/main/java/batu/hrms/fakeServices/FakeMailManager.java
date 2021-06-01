package batu.hrms.fakeServices;

import batu.hrms.core.utilities.results.ErrorResult;
import batu.hrms.core.utilities.results.Result;
import batu.hrms.core.utilities.results.SuccessResult;

public class FakeMailManager {

	public void sendMail(String email, String message) {
		System.out.println("Mail gonderildi. Lutfen " + email +" adresli mailinizi kontrol ediniz." +message);
	}
	
	public Result verifyMail(String mail, String verificationCode, String verificationCode2) {
		if(verificationCode!= verificationCode2) {
			return new ErrorResult("Lutfen dogru kodu yazdiginizdan emin olunuz!");
		}
		return new SuccessResult(mail+" mail adresinin dogrulamasi basariyla gerceklesti.");
	}
}
