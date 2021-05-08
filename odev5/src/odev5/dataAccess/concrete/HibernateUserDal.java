package odev5.dataAccess.concrete;


import odev5.dataAccess.abstracts.IUserDal;
import odev5.entities.concrete.User;

public class HibernateUserDal implements IUserDal {

	@Override
	public void registerWithPersonalInformations(User user) {
		System.out.println("Do�rulama e-postas� g�nderildi -> " + user.getEmail());
		System.out.println("Ki�isel bilgiler ile kay�t olundu: " + user.getFirstName());
	}

	@Override
	public void registerWithGoogleAccount(User user) {
		System.out.println("Google hesab� ile kay�t olundu: " + user.getFirstName());
	}

	@Override
	public void login(User user) {
		System.out.println("Giri� yap�ld�: " + user.getFirstName());
	}

}
