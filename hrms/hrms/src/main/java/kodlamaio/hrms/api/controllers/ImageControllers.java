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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.dataResults.ErrorDataResult;
import kodlamaio.hrms.entities.concretes.cvConcretes.Image;

@RestController
@RequestMapping("/api/images")
public class ImageControllers {
	private ImageService imageService;

	@Autowired
	public ImageControllers(ImageService imageService) {
		super();
		this.imageService = imageService;
	}

	@PostMapping(value = "/add")
	public ResponseEntity<?> add(@Valid @RequestBody Image image, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		return ResponseEntity.ok(this.imageService.add(image, imageFile));
	}

	@PostMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestParam Image image) {
		return ResponseEntity.ok(this.imageService.update(image));

	}

	@PostMapping("/delete")
	public ResponseEntity<?> delete(@RequestBody Image image) {
		return ResponseEntity.ok(this.imageService.delete(image));

	}

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.imageService.getAll());
	}

	@GetMapping("/getAllByCandidateId")
	public ResponseEntity<?> getByCvId(@RequestParam int id) {
		return ResponseEntity.ok(this.imageService.getByCvId(id));
	}

	@GetMapping("/getById")
	public ResponseEntity<?> getById(@RequestParam int id) {
		return ResponseEntity.ok(this.imageService.getById(id));
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
