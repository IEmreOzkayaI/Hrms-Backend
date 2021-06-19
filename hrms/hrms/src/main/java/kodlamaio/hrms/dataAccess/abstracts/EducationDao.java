package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.cvConcretes.School;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvSchool;
import kodlamaio.hrms.entities.dtos.SchoolDto;
@Repository
public interface SchoolDao extends JpaRepository<School, Integer> {
    @Query("from School order by endDate asc nulls first ")
	List<School> findAllOrderByAsc();
    
    @Query("from CvSchool s where cv.id=:id ")
	List<CvSchool> findByCvIdOrderByAsc(@Param(value = "id") int id);

	@Query("Select new kodlamaio.hrms.entities.dtos.SchoolDto"
			+ "(s.name,s.department,s.startDate,s.endDate)"
			+ "from CvSchool c "
			+ "Inner Join c.school s "
			+ "where c.cv.jobSeeker.id=:id ")
	List<SchoolDto> findByCv_id(@Param(value = "id") int id);
}
