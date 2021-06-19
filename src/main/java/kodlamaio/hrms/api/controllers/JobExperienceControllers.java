package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.dataResults.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.cvConcretes.Experience;

@RestController
@RequestMapping("/api/job_experience")
public class JobExperienceControllers {
	private ExperienceService jobExperienceService;

	@Autowired
	public JobExperienceControllers(ExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}

	@PostMapping("/add")

	public ResponseEntity<?> add(@Valid @RequestParam int cvId, @RequestBody Experience jobExperience) {
		return ResponseEntity.ok(this.jobExperienceService.add(cvId, jobExperience));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestParam int cvId, @RequestBody Experience jobExperience) {
		return ResponseEntity.ok(this.jobExperienceService.update(cvId,jobExperience));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@Valid @RequestBody int id) {
		return ResponseEntity.ok(this.jobExperienceService.delete(id));
	}

	@GetMapping("/findByOrderByAsc")
	public ResponseEntity<?> findByOrderByAsc() {
		return ResponseEntity.ok(this.jobExperienceService.findByOrderByAsc());
	}

	@GetMapping("/findByCvIdOrderByAsc")
	public ResponseEntity<?> findByCvIdOrderByAsc(int id) {
		return ResponseEntity.ok(this.jobExperienceService.findByCvIdOrderByAsc(id));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions) {
		Map<String, String> validationErrors = new HashMap<String, String>();
		for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "Doğrulama Hataları");
		return errors;
	}
}
