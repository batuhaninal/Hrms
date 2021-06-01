package batu.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import batu.hrms.business.abstracts.JobTitleService;
import batu.hrms.core.utilities.results.DataResult;
import batu.hrms.core.utilities.results.ErrorResult;
import batu.hrms.core.utilities.results.Result;
import batu.hrms.core.utilities.results.SuccessDataResult;
import batu.hrms.core.utilities.results.SuccessResult;
import batu.hrms.dataAccess.abstracts.JobTitleDao;
import batu.hrms.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService {
	
	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll());
	}

	@Override
	public Result add(JobTitle jobTitle) {
		if(isExist(jobTitle.getName())) 
		{
			return new ErrorResult("Bu is pozisyonu zaten mevcut");
		}
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult();
		
	}
	
	boolean isExist(String name) {
		return jobTitleDao.findAllByName(name).stream().count()>=1;
	}
	
}
