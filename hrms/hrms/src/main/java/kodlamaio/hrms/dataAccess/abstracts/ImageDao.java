package kodlamaio.hrms.dataAccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.cvConcretes.Image;
@Repository
public interface ImageDao extends JpaRepository<Image, Integer> {
	Image findByCv_id(int id);
	Image findById(int id);
}
