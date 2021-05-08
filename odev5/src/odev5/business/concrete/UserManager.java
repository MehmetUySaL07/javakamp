package odev5.business.concrete;

import odev5.business.abstracts.IUserService;
import odev5.core.IEmailValidator;
import odev5.dataAccess.abstracts.IUserDal;
import odev5.entities.concrete.User;

public class UserManager implements IUserService {
	private IUserDal _userDal;
	private IEmailValidator _emailValidator;

	public UserManager(IUserDal _userDal, IEmailValidator _emailValidator) {
		super();
		this._userDal = _userDal;
		this._emailValidator = _emailValidator;
	}

	@Override
	public void registerWithPersonalInformations(User user) {	
		if(user.getEmail()==null || user.getFirstName()==null || user.getLastName()==null || user.getPassword()==null) {
			System.out.println("Gerekli kullan�c� bilgileri bo� olamaz");
		}
		
		else if(user.getPassword().length() < 6) {
			System.out.println("Parola en az 6 karakter olmal�d�r.");
		}
		
		else if(this._emailValidator.validate(user.getEmail())==false) {
			System.out.println("Ge�erli bir email de�il.");
		}
		
		else if(user.getFirstName().length() < 2) {
			System.out.println("�sim en az 2 karakterden olu�mal�d�r.");
		}
		
		else if(user.getLastName().length() < 2) {
			System.out.println("Soyisim en az 2 karakterden olu�mal�d�r.");
		}
		
		else{
			this._userDal.registerWithPersonalInformations(user);
		}
	}

	@Override
	public void registerWithGoogleAccount(User user) {
		this._userDal.registerWithGoogleAccount(user);
	}

	@Override
	public void login(User user) {
		if(user.getEmail().length() == 0 || user.getPassword().length() == 0) {
			System.out.println("Email ve �ifre girilmesi zorunludur.");
		}
		else {
			this._userDal.login(user);
		}
	}
}
