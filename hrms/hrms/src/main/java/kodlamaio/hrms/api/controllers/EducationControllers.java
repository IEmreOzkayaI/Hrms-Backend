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

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.dataResults.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.cvConcretes.Education;

@RestController
@RequestMapping("/api/school")
public class EducationControllers {
	private EducationService educationService;

	@Autowired
	public EducationControllers(EducationService educationService) {
		super();
		this.educationService = educationService;
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestParam int cvId, @RequestBody Education education) {
		return ResponseEntity.ok(this.educationService.add(cvId,education));
	}

	@DeleteMapping("/deleteById")
	public ResponseEntity<?> delete(int educationId) {
		return ResponseEntity.ok(this.educationService.delete(educationId));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestParam int cvId, @RequestBody Education education) {
		return ResponseEntity.ok(this.educationService.update(cvId,education));
	}

	@GetMapping("/sortWithCvIdAsc")
	public ResponseEntity<?> findByCv_id(@RequestParam int id) {
		return ResponseEntity.ok(this.educationService.findByCv_id(id));
	}

	@GetMapping("/sortAllCvSchoolAsc")
	public ResponseEntity<?> findAllOrderByAsc() {
		return ResponseEntity.ok(this.educationService.findAllOrderByAsc());
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
