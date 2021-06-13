package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer>{	
	@Query("Select new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(j.id,e.companyName,jp.positionName,j.openPositions,j.releaseDate,j.lastDate)"
			+ "From JobAdvertisement j "
			+ "Inner Join j.employer e "
			+ "Inner Join j.jobPositionId jp "
			+ "where j.isActive=true ")
	List<JobAdvertisementDto>  findJobAdvertisementIsActiveTrue();
	
	@Query("Select "
			+ "new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(j.id,e.companyName,jp.positionName,j.openPositions,j.releaseDate,j.lastDate)"
			+ "From JobAdvertisement j "
			+ "Inner Join j.employer e "
			+ "Inner Join j.jobPositionId jp "
			+ "where j.isActive=true  "
			+ "order by j.releaseDate ")
	List<JobAdvertisementDto>  findJobAdvertisementIsActiveTrueOrderByReleaseDate();
	
	@Query("Select "
			+ "new kodlamaio.hrms.entities.dtos.JobAdvertisementDto"
			+ "(j.id,e.companyName,jp.positionName,j.openPositions,j.releaseDate,j.lastDate)"
			+ "From JobAdvertisement j "
			+ "Inner Join j.employer e "
			+ "Inner Join j.jobPositionId jp "
			+ "where j.isActive=true and j.employer.id=:id ")
	List<JobAdvertisementDto>  findJobAdvertisementIsActiveTrueAndEmployer_UserId(@Param(value = "id") int id);
}
