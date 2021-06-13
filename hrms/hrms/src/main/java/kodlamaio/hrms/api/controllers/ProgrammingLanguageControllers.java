package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.cvConcretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programming_langugage")
public class ProgrammingLanguageControllers {
	private ProgrammingLanguageService programmingLanguageService;

	@Autowired
	public ProgrammingLanguageControllers(ProgrammingLanguageService programmingLanguageService) {
		super();
		this.programmingLanguageService = programmingLanguageService;
	}

	@PostMapping("/add")
	public Result add(ProgrammingLanguage programmingLanguage) {
		return this.programmingLanguageService.add(programmingLanguage);
	}
}
