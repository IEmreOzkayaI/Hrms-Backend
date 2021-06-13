package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;


@RestController
@RequestMapping("/api/jobAdvertisement")

public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getJobAdvertisementIsActiveTrue")
	public DataResult<List<JobAdvertisementDto>> findJobAdvertisementIsActiveTrue(){
		return this.jobAdvertisementService.findJobAdvertisementIsActiveTrue();
	}
	
	@GetMapping("/findJobAdvertisementIsActiveTrueOrderByReleaseDate")
	public DataResult<List<JobAdvertisementDto>> findJobAdvertisementIsActiveTrueOrderByReleaseDate() {
		return this.jobAdvertisementService.findJobAdvertisementIsActiveTrueOrderByReleaseDate();
	}
	
	@GetMapping("/findByEmployer_Id")
	public DataResult<List<JobAdvertisementDto>> findJobAdvertisementIsActiveTrueAndEmployer_UserId(@RequestParam int id) {
		return this.jobAdvertisementService.findJobAdvertisementIsActiveTrueAndEmployer_UserId(id);
	}
	
	@GetMapping("/closeJobAdvertisement")
	public Result closeJobAdvertisement(@RequestParam int id){
		return this.jobAdvertisementService.closeJobAdvertisement(id);
	}

	
}
