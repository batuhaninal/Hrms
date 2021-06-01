package batu.hrms.business.concretes;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import batu.hrms.business.abstracts.JobSeekerService;
import batu.hrms.core.serviceAdapters.EmailService;
import batu.hrms.core.serviceAdapters.MernisService;
import batu.hrms.core.utilities.results.DataResult;
import batu.hrms.core.utilities.results.ErrorResult;
import batu.hrms.core.utilities.results.Result;
import batu.hrms.core.utilities.results.SuccessDataResult;
import batu.hrms.core.utilities.results.SuccessResult;
import batu.hrms.dataAccess.abstracts.JobSeekerDao;
import batu.hrms.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private EmailService emailService;
	private MernisService mernisService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, EmailService emailService, MernisService mernisService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.emailService = emailService;
		this.mernisService = mernisService;
	}
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll());
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		if(!emailService.verifyEmail(jobSeeker.getMail(), "10", "10") .isSuccess() ||
				!mernisService.mernis("Hello World").isSuccess() ||
				!isMailExist(jobSeeker.getMail()).isSuccess() ||
				!isNIdentityExist(jobSeeker.getNationalIdentity()).isSuccess() ||
				!isNullDate(jobSeeker.getDateOfBirth()).isSuccess() ||
				!isNullFirstName(jobSeeker.getFirstName()).isSuccess() ||
				!isNullLastName(jobSeeker.getLastName()).isSuccess() ||
				!isNullMail(jobSeeker.getMail()).isSuccess() ||
				!isNullNationalIdentity(jobSeeker.getNationalIdentity()).isSuccess())
		{
			return new ErrorResult("Lutfen bilgilerinizi kontrol ediniz.");
		}
		jobSeekerDao.save(jobSeeker);
		return new SuccessResult("Kullanici basariyla sisteme eklendi");
	}
	
	Result isMailExist(String mail) {
		if(jobSeekerDao.findAllByMail(mail).stream().count()>=1) {
			return new ErrorResult("Bu mail adresi mevcut");
		}
		return new SuccessResult();
	}
	
	Result isNIdentityExist(String identity) {
		if(this.jobSeekerDao.findAllByNationalIdentity(identity).stream().count()>=1) {
			return new ErrorResult("Bu kimlik numarasi mevcut");
		}
		return new SuccessResult();
	}
	
	Result isNullFirstName(String name) {
		if(name == null || name.isEmpty()) {
			return new ErrorResult("Isim bos birakilamaz");
		}
		return new SuccessResult();
	}
	
	Result isNullLastName(String lastName) {
		if(lastName == null || lastName.isEmpty()) {
			return new ErrorResult("Soyad alani bos birakilamaz");
		}
		return new SuccessResult();
	}
	
	Result isNullNationalIdentity(String nIdentity) {
		if(nIdentity == null || nIdentity.isEmpty()) {
			return new ErrorResult("Tc kimlik bilgisi bos birakilamaz");
		}
		return new SuccessResult();
	}
	
	Result isNullDate(Date date) {
		if(date == null) {
			return new ErrorResult("Tarih bilgisi bos birakilamaz");
		}
		return new SuccessResult();
	}
	
	Result isNullMail(String mail) {
		if(mail == null || mail.isEmpty()) {
			return new ErrorResult("Mail bilgisi bos birakilamaz");
		}
		return new SuccessResult();
	}
	
	Result isNullPassword(String lastName) {
		if(lastName == null || lastName.isEmpty()) {
			return new ErrorResult("Sifre alani bos birakilamaz");
		}
		return new SuccessResult();
	}
	
}
