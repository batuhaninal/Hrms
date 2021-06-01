package batu.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper=true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers")
public class JobSeeker extends User {
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth; 
}
