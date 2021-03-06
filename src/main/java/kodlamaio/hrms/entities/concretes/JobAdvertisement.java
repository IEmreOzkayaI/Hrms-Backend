package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPositionId;

	@Column(name="job_description")
	@NotBlank
	@NotNull
	private String jobDescription;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;

	@Column(name = "min_salary")
	private int minSalary;

	@Column(name = "max_salary")
	private int maxSalary;

	@Column(name = "open_positions")
	@NotNull
	private int openPositions;

	@Column(name = "last_Date")
	private Date lastDate;

	@Column(name = "is_activated")
	private boolean isActive;
	
	@Column(name = "date")
	private Date releaseDate;
}
