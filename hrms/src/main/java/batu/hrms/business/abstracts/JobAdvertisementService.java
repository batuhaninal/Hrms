package batu.hrms.business.abstracts;

import java.util.List;

import batu.hrms.core.utilities.results.DataResult;
import batu.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	DataResult<List<JobAdvertisement>> getByJobTitle_JobTitleId(int jobTitleId);
	
	DataResult<List<JobAdvertisement>> findByIsActiveTrue();
	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate();
	DataResult<List<JobAdvertisement>> findByCity_Id(int cityId);
	DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployer_Id(int employerId);
}
