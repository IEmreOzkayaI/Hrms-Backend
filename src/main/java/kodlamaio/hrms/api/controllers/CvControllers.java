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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvService;
import kodlamaio.hrms.core.utilities.dataResults.ErrorDataResult;

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
	public ResponseEntity<?> add(@Valid @RequestParam String github, String linkedin, String biography, int userId) {
		return ResponseEntity.ok(this.cvService.add(github, linkedin, biography, userId));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<?> delete(@RequestParam int id) {
		return ResponseEntity.ok(this.cvService.delete(id));
	}

	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestParam String github, String linkedin, String biography, int userId) {
		return ResponseEntity.ok(this.cvService.update(github, linkedin, biography, userId));
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll( ) {
		return ResponseEntity.ok(this.cvService.getAll());
	}
	
	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.cvService.getById(id));
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
