package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ProgrammingLanguageService;
import kodlamaio.hrms.core.utilities.dataResults.ErrorDataResult;
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
	public ResponseEntity<?> add(@Valid @RequestParam ProgrammingLanguage programmingLanguage) {
		return ResponseEntity.ok(this.programmingLanguageService.add(programmingLanguage));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Doğrulama Hataları");
		return errors;
	}
}
