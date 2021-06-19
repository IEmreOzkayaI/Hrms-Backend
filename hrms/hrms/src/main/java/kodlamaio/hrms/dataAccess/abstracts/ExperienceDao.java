package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.cvConcretes.Experience;
@Repository
public interface ExperienceDao extends JpaRepository<Experience, Integer> {
	
	Experience findById(int id);
	
	@Query("from Experience order by endDate asc nulls first ")
	List<Experience> findByOrderByAsc();

	@Query("From Experience  "
			+ " where cv.id=:id "
			+ " order by endDate asc nulls first ")
	List<Experience> findByCvIdOrderByAsc(@Param(value = "id") int id);
	
	List<Experience> findByCv_id(@Param(value = "id") int id);

}
