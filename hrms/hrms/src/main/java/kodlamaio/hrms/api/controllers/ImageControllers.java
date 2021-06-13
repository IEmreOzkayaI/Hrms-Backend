package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.ImageService;
import kodlamaio.hrms.core.utilities.dataResults.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Cv;
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
	public Result add(@RequestBody Image image, @RequestParam(value = "imageFile") MultipartFile imageFile) {
		return this.imageService.add(image,imageFile);
	}

	@PostMapping("/update")
	public Result update(@RequestParam Image image) {
		return this.imageService.update(image);

	}

	@PostMapping("/delete")
	public Result delete(@RequestBody Image image) {
		return this.imageService.delete(image);

	}

	@GetMapping("/getall")
	public DataResult<List<Image>> getAll() {
		return this.imageService.getAll();
	}

	@GetMapping("/getAllByCandidateId")
	public DataResult<Image> getByCvId(@RequestParam int id) {
		return this.imageService.getByCvId(id);
	}

	@GetMapping("/getById")
	public DataResult<Image> getById(@RequestParam int id) {
		return this.imageService.getById(id);
	}
}