package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "system_personnels")
@PrimaryKeyJoinColumn(name = "user_id", referencedColumnName = "id")
public class SystemPersonnel extends User {

	@Column(name = "first_name")
	@NotBlank
	@NotNull
	private String firstName;

	@Column(name = "last_name")
	@NotBlank
	@NotNull
	private String lastName;
}
