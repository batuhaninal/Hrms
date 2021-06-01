package batu.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import batu.hrms.business.abstracts.JobAdvertisementService;
import batu.hrms.core.utilities.results.DataResult;
import batu.hrms.core.utilities.results.SuccessDataResult;
import batu.hrms.dataAccess.abstracts.JobAdvertisementDao;
import batu.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findAll());
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByJobTitle_JobTitleId(int jobTitleId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.getByJobTitle_JobTitleId(jobTitleId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrue());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate() {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrueOrderByCreateDate());
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByCity_Id(int cityId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByCity_Id(cityId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployer_Id(int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(jobAdvertisementDao.findByIsActiveTrueAndEmployer_Id(employerId));
	}

}
