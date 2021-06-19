package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemPersonnelActivationService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;
import kodlamaio.hrms.entities.concretes.SystemPersonnelActivation;

@RestController
@RequestMapping("/api/systemPersonnelActivationControllers")
public class SystemPersonnelActivationControllers {

	private SystemPersonnelActivationService service;

	@Autowired
	public SystemPersonnelActivationControllers(SystemPersonnelActivationService service) {
		super();
		this.service = service;
	}

	@PostMapping("/activate")
	public ResponseEntity<?> activate(@RequestParam boolean activationResult,@RequestParam int employerId,@RequestParam int systemPersonnelId) {
		return ResponseEntity.ok(this.service.activate(activationResult, employerId, systemPersonnelId));
	}

	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {
		return ResponseEntity.ok(this.service.getAll());
	}

}
