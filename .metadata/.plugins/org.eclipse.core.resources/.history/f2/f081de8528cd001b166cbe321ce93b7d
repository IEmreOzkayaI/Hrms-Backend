package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.cvConcretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageDto;
import kodlamaio.hrms.entities.dtos.SchoolDto;

public interface LanguageDao  extends JpaRepository<Language, Integer>{
	@Query("Select new kodlamaio.hrms.entities.dtos.LanguageDto"
			+ "(l.language,l.level)"
			+ "from CvLanguage c "
			+ "Inner Join c.language l "
			+ "where c.cv.jobSeeker.id=:id ")
	List<LanguageDto> findByCv_id(@Param(value = "id") int id);
}
