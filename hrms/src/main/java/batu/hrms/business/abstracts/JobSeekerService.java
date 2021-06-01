package batu.hrms.business.abstracts;

import java.util.List;

import batu.hrms.core.utilities.results.DataResult;
import batu.hrms.core.utilities.results.Result;
import batu.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {
	 
	DataResult<List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker);
}
