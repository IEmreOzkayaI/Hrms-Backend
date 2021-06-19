package kodlamaio.hrms.entities.concretes.cvConcretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import kodlamaio.hrms.entities.concretes.Cv;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "educations")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cv_id")
	private Cv cv;

	@Column(name = "name")
	@NotNull
	private String name;

	@Column(name = "department")
	@NotNull
	private String department;

	@Column(name = "start_date")
	@NotNull
	private Date startDate;

	@Column(name = "end_date")
	private String endDate;

	public String getEndDate() {
		if (this.endDate == null)
			return "Devam ediyor";
		else
			return this.endDate.toString();
	}

}
