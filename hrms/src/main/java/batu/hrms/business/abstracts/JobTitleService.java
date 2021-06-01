package batu.hrms.business.abstracts;

import java.util.List;

import batu.hrms.core.utilities.results.DataResult;
import batu.hrms.core.utilities.results.Result;
import batu.hrms.entities.concretes.JobTitle;

public interface JobTitleService {
	DataResult<List<JobTitle>> getAll();
	Result add(JobTitle jobTitle);
}
