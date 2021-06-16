package kodlamaio.hrms.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.dataResults.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobAdvertisement")
@CrossOrigin
public class JobAdvertisementController {
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody JobAdvertisement jobAdvertisement) {
		return ResponseEntity.ok(this.jobAdvertisementService.add(jobAdvertisement));
	}

	@GetMapping("/getJobAdvertisementIsActiveTrue")
	public ResponseEntity<?> findJobAdvertisementIsActiveTrue() {
		return ResponseEntity.ok(this.jobAdvertisementService.findJobAdvertisementIsActiveTrue());
	}

	@GetMapping("/findJobAdvertisementIsActiveTrueOrderByReleaseDate")
	public ResponseEntity<?> findJobAdvertisementIsActiveTrueOrderByReleaseDate() {
		return ResponseEntity.ok(this.jobAdvertisementService.findJobAdvertisementIsActiveTrueOrderByReleaseDate());
	}

	@GetMapping("/findByEmployer_Id")
	public ResponseEntity<?> findJobAdvertisementIsActiveTrueAndEmployer_UserId(@RequestParam int id) {
		return ResponseEntity.ok(this.jobAdvertisementService.findJobAdvertisementIsActiveTrueAndEmployer_UserId(id));
	}

	@GetMapping("/closeJobAdvertisement")
	public ResponseEntity<?> closeJobAdvertisement(@RequestParam int id) {
		return ResponseEntity.ok(this.jobAdvertisementService.closeJobAdvertisement(id));
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
