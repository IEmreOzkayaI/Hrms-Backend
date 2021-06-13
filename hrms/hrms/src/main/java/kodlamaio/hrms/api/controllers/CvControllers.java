package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
import kodlamaio.hrms.entities.dtos.CvDto;

@RestController
@RequestMapping("/api/cv")
public class CvControllers {
	private CvService cvService;
	@Autowired
	public CvControllers(CvService cvService) {
		super();
		this.cvService = cvService;
	} 
	@PostMapping("/add")
	public	Result add(@RequestBody Cv cv) {
		return this.cvService.add(cv);
	}

	@GetMapping("/getAllCv")
	public DataResult<CvDto> getById(@RequestParam int id) {
		return this.cvService.getById(id);
	}

}
