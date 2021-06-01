package batu.hrms.fakeServices;

import batu.hrms.core.utilities.results.Result;
import batu.hrms.core.utilities.results.SuccessResult;

public class FakeMernisManager {
	public Result mernis(String message) {
		return new SuccessResult("Dogrulama basarili " + message);
	}
}
