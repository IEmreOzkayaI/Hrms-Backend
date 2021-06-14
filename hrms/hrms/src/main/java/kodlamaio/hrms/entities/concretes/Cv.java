package kodlamaio.hrms.entities.concretes;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import kodlamaio.hrms.entities.concretes.cvConcretes.Image;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvExperience;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvLanguage;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvProgrammingLanguage;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvSchool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "resumes")
public class Cv {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@NotNull
	private int id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="user_id")
	private JobSeeker jobSeeker;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvSchool> cvSchools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvExperience> cvExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvLanguage> cvLanguages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "cv")
	private List<CvProgrammingLanguage> cvProgrammingLanguages;
	
	@JsonIgnore
	@OneToOne(mappedBy = "cv")
	private Image image;
	
	@Column(name="github")
	@NotNull
	private String github;
	
	@Column(name="linkedin")
	@NotNull
	private String linkedin;
	
	@Column(name="biography")
	@NotNull
	private String biography;
		
}
