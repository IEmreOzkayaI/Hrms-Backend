package kodlamaio.hrms.entities.concretes.cvConcretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvExperience;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_experiences")
public class JobExperience {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "position")
	private String position;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	public String getEndDate() {
		if (this.endDate == null)
			return "Devam ediyor";
		return this.endDate.toString();
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobExperience")
	private List<CvExperience> cvExperiences;
}
