package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.cvConcretes.ProgrammingLanguage;
import kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto;

@Repository
public interface ProgrammingLanguageDao extends JpaRepository<ProgrammingLanguage, Integer> {
	ProgrammingLanguage findById(int id);
	@Query("Select new kodlamaio.hrms.entities.dtos.ProgrammingLanguageDto(pl.name) from CvProgrammingLanguage c inner join c.programmingLanguage pl where c.cv.id=:id")
	List<ProgrammingLanguageDto> findByCv_id(@Param(value = "id") int id);
	
	ProgrammingLanguage findByName(String name);


}
