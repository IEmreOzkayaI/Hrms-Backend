package kodlamaio.hrms.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.entities.concretes.Employer;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employer")
@AllArgsConstructor
public class EmployerController {
	private EmployerService employerService;

	@GetMapping("/getall")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.employerService.getAll());
	}

	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Employer employer) {
		return ResponseEntity.ok(this.employerService.add(employer));
	}

}
