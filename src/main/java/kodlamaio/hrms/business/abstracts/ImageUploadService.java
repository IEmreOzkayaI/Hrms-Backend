package kodlamaio.hrms.business.abstracts;

import java.io.File;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.dataResults.DataResult;

public interface ImageUploadService {
	String uploadImageFile(File imageFile);
}
