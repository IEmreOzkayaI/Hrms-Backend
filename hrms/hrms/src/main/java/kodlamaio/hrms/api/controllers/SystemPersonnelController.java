package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/system-personnel")
public class SystemPersonnelController {
	private SystemPersonnelService systemPersonnelService;

	@Autowired
	public SystemPersonnelController(SystemPersonnelService systemPersonnelService) {
		super();
		this.systemPersonnelService = systemPersonnelService;
	}

	@GetMapping("/getall")
	public DataResult<List<SystemPersonnel>> getAll() {
		return this.systemPersonnelService.getAll();
	}

}
