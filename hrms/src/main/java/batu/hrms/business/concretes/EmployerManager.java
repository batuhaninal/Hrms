package batu.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import batu.hrms.business.abstracts.EmployerService;
import batu.hrms.core.serviceAdapters.EmailService;
import batu.hrms.core.utilities.results.DataResult;
import batu.hrms.core.utilities.results.ErrorResult;
import batu.hrms.core.utilities.results.Result;
import batu.hrms.core.utilities.results.SuccessDataResult;
import batu.hrms.core.utilities.results.SuccessResult;
import batu.hrms.dataAccess.abstracts.EmployerDao;
import batu.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private EmailService emailService;
	
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, EmailService emailService) {
		super();
		this.employerDao = employerDao;
		this.emailService = emailService;
	}

	@Override
	public Result add(Employer employer) {
		if(!emailService.verifyEmail(employer.getMail(), "10", "10").isSuccess() || 
				!isMailExist(employer.getMail()).isSuccess() || 
				!isNullCompanyName(employer.getCompanyName()).isSuccess() ||
				!isNullWebAddress(employer.getWebAddress()).isSuccess() || 
				!isNullMail(employer.getMail()).isSuccess() ||
				!isNullPhoneNumber(employer.getPhoneNumber()).isSuccess() ||
				!isNullPassword(employer.getPassword()).isSuccess()) 
		{
			return new ErrorResult("Lutfen bilgilerinizi kontrol ediniz");
		}
		this.employerDao.save(employer);
		return new SuccessResult("Kullanici basariyla sisteme eklendi.");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}
	
	Result isMailExist(String mail) {
		if(this.employerDao.findAllByMail(mail).stream().count()>=1) {
			return new ErrorResult();
		}
		return new SuccessResult();
	}
	
	Result isNullCompanyName(String companyName) {
		if(companyName == null || companyName.isEmpty()) {
			return new ErrorResult("Sirket ismi bos birakilamaz");
		}
		return new SuccessResult();
	}
	
	Result isNullWebAddress(String webAddress) {
		if(webAddress == null || webAddress.isEmpty()) {
			return new ErrorResult("Web adres bilgisi bos birakilamaz");
		}
		return new SuccessResult();
	}
	
	Result isNullMail(String mail) {
		if(mail == null || mail.isEmpty()) {
			return new ErrorResult("Mail bilgisi bos birakilamaz");
		}
		return new SuccessResult();
	}
	
	Result isNullPassword(String password) {
		if(password == null || password.isEmpty()) {
			return new ErrorResult("Sifre bilgisi bos birakilamaz");
		}
		return new SuccessResult();
	}
	
	Result isNullPhoneNumber(String phoneNumber) {
		if(phoneNumber == null || phoneNumber.isEmpty()) {
			return new ErrorResult("Telefon numarasi bilgisi bos birakilamaz");
		}
		return new SuccessResult();
	}
}
