package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvProgrammingLanguage;
@Repository
public interface CvProgrammingLanguageDao extends JpaRepository<CvProgrammingLanguage, Integer> {

}
