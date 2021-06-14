package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;
@Repository
public interface CvDao extends JpaRepository<Cv, Integer> {
	@Query("Select new kodlamaio.hrms.entities.dtos.CvDto"
			+ "(j.firstName,j.lastName,j.dateOfBirth,c.image.imageUrl,c.github,c.linkedin,j.id,c.biography)"
			+ "From Cv c inner join c.jobSeeker j "
			+ "where c.id=:id ")
	CvDto findById(@Param(value = "id") int cvId);
}
