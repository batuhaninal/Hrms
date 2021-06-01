package batu.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import batu.hrms.business.abstracts.JobAdvertisementService;
import batu.hrms.core.utilities.results.DataResult;
import batu.hrms.entities.concretes.JobAdvertisement;


@RestController
@RequestMapping("/jobAdvertisement")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@GetMapping("/getall")
	DataResult<List<JobAdvertisement>> getAll(){
		return jobAdvertisementService.getAll();
	}
	
	@GetMapping("/getByJobTitle")
	DataResult<List<JobAdvertisement>> getByJobTitle_JobtitleId(@RequestParam int jobTitleId){
		return jobAdvertisementService.getByJobTitle_JobTitleId(jobTitleId);
	}
	
	@GetMapping("/findByIsActiveTrue")
	DataResult<List<JobAdvertisement>> findByIsActiveTrue(){
		return jobAdvertisementService.findByIsActiveTrue();
	}
	
	@GetMapping("/findByIsActiveTrueOrderByCreateDate")
	DataResult<List<JobAdvertisement>> findByIsActiveTrueOrderByCreateDate(){
		return jobAdvertisementService.findByIsActiveTrueOrderByCreateDate();
	}
	
	@GetMapping("/findByCityId")
	DataResult<List<JobAdvertisement>> findByCity_Id(@RequestParam int cityId){
		return jobAdvertisementService.findByCity_Id(cityId);
	}
	
	@GetMapping("/findByIsActiveTrueAndEmployerId")
	DataResult<List<JobAdvertisement>> findByIsActiveTrueAndEmployer_Id(@RequestParam int employerId){
		return jobAdvertisementService.findByIsActiveTrueAndEmployer_Id(employerId);
	}
	
}
