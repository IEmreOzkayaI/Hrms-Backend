package kodlamaio.hrms.entities.dtos;

import java.util.Date;
import java.util.List;

import kodlamaio.hrms.entities.concretes.cvConcretes.Education;
import kodlamaio.hrms.entities.concretes.cvConcretes.Experience;
import kodlamaio.hrms.entities.concretes.cvConcretes.Language;
import kodlamaio.hrms.entities.concretes.cvConcretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CvDto {
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
	private String image;
	private String github;
	private String linkedin;
	private String biography;
	private int jobSeeker;
	
	private List<Education> educations;
	private List<Experience> experiences;
	private List<Language> languages;
	private List<ProgrammingLanguageDto> programmingLanguages;

	public CvDto(String firstName, String lastName, Date dateOfBirth, String image, String github, String linkedin,
			int jobSeeker, String biography) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.image = image;
		this.github = github;
		this.linkedin = linkedin;
		this.jobSeeker = jobSeeker;
		this.biography = biography;

	}

}
