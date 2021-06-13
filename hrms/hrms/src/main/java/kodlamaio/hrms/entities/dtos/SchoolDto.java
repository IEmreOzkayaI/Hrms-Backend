package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchoolDto {
	private String name;
	private String department;
	private Date startDate;
	private Date endDate;
	
	public String getEndDate() {
		if (this.endDate == null)
			return "Devam ediyor";
		return this.endDate.toString();
	}
}
