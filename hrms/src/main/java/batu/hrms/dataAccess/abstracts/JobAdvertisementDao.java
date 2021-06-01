package batu.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import batu.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{

	List<JobAdvertisement> getByJobTitle_JobTitleId(int jobTitleId);
	
	List<JobAdvertisement> findByIsActiveTrue();
	List<JobAdvertisement> findByIsActiveTrueOrderByCreateDate();
	List<JobAdvertisement> findByCity_Id(int cityId);
	List<JobAdvertisement> findByIsActiveTrueAndEmployer_Id(int employerId);
}
