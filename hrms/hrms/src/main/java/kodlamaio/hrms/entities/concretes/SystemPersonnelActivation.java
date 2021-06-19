package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "system_personnel_activation")
public class SystemPersonnelActivation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
	
	@JsonIgnore
	@JoinColumn(name="system_personnel_id")
	@ManyToOne
	private SystemPersonnel systemPersonnel;
	
	@Column(name="is_confirmed")
	private boolean isActivated;
	
}
