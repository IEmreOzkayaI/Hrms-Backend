package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.cvConcretes.Education;
@Repository
public interface EducationDao extends JpaRepository<Education, Integer> {
	
	Education getById(int id );
	
    @Query("from Education order by endDate asc nulls first ")
	List<Education> findAllOrderByAsc();

	@Query("From Education "
			+ "where cv.id=:id "
			+ "order by endDate asc nulls first")
	List<Education> findByCv_id(@Param(value = "id") int id);
}
