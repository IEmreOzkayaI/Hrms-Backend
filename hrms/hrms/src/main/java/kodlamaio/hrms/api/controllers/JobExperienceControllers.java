package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.JobExperience;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvExperience;

@RestController
@RequestMapping("/api/job_experience")
public class JobExperienceControllers {
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperienceControllers(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	@PostMapping("/add")

	public Result add(@RequestBody JobExperience jobExperience) {
		return this.jobExperienceService.add(jobExperience);
	}
	@GetMapping("/findByOrderByAsc")
	public 	DataResult<	List<JobExperience>> findByOrderByAsc(){
		return this.jobExperienceService.findByOrderByAsc();
	}
	@GetMapping("/findByCvIdOrderByAsc")
	public DataResult<List<CvExperience>> findByCvIdOrderByAsc(int id) {
		return this.jobExperienceService.findByCvIdOrderByAsc(id);
	}

}
