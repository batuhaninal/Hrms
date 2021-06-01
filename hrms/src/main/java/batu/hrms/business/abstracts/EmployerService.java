package batu.hrms.business.abstracts;

import java.util.List;

import batu.hrms.core.utilities.results.DataResult;
import batu.hrms.core.utilities.results.Result;
import batu.hrms.entities.concretes.Employer;

public interface EmployerService {

	Result add(Employer employer);
	
	DataResult<List<Employer>> getAll();
}
