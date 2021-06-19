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
import com.sun.istack.NotNull;

import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvSchool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schools")
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;

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
	private Date endDate;

	@JsonIgnore
	@OneToMany(mappedBy = "school")
	private List<CvSchool> cvSchools;

	public String getEndDate() {
		if (this.endDate == null)
			return "Devam ediyor";
		return this.endDate.toString();
	}

}
