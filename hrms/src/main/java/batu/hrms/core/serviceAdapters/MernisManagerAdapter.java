package batu.hrms.core.serviceAdapters;

import org.springframework.stereotype.Service;

import batu.hrms.core.utilities.results.Result;
import batu.hrms.fakeServices.FakeMernisManager;

@Service
public class MernisManagerAdapter implements MernisService {

	FakeMernisManager mernis = new FakeMernisManager();
	
	@Override
	public Result mernis(String message) {
		return mernis.mernis(message);
	}

}
