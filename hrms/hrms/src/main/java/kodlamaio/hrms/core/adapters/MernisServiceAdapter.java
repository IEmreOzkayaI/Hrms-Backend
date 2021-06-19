package kodlamaio.hrms.core.adapters;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.abstracts.MernisValidationService;
import kodlamaio.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
//import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;
@Service
public class MernisServiceAdapter  implements MernisValidationService{

	@Override
	public boolean validate(JobSeeker jobSeeker)  {
		// FAKE DOĞRULAMA SİSTEMİDİR.
//			KPSPublicSoap soapClient = new KPSPublicSoapProxy();
//			boolean result = false;
//			  try {
//				  result = soapClient.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getIdentityNumber()), jobSeeker.getFirstName(), jobSeeker.getLastName(), jobSeeker.getDateOfBirth().getYear());
//			  } catch (NumberFormatException e) {
//				   e.printStackTrace();
//			  } catch (RemoteException e) {
//			       e.printStackTrace();
//			  }
//			 return result;
//		}

		return true;
	}
	
	
}
