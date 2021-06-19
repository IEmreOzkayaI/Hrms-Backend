package kodlamaio.hrms.entities.concretes.cvConcretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.concretes.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "resumes" })
public class Language {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;

	@Column(name = "language")
	private String language;

	@Min(1)
	@Max(5)
	@Column(name = "level")
	private int level;

}
