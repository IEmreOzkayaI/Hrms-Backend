package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.School;
import kodlamaio.hrms.entities.concretes.cvConcretes.CompoundConcretes.CvSchool;

@RestController
@RequestMapping("/api/school")
public class SchoolControllers {
	private SchoolService schoolService;

	@Autowired
	public SchoolControllers(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody School school) {
		return this.schoolService.add(school);
	}
	
	@GetMapping("/sortWithCvIdAsc")
	public DataResult<List<CvSchool>> findByCvIdOrderByAsc(@RequestParam int id) {
		return this.schoolService.findByCvIdOrderByAsc(id);
	}
	
	@GetMapping("/sortAllAsc")
	public DataResult<List<School>> findAllOrderByAsc() {
		return this.schoolService.findAllOrderByAsc();
	}



}
