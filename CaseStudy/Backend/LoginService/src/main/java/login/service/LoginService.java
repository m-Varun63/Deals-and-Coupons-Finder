package login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.model.Login;
import login.repo.LoginRepo;

@Service
public class LoginService {
	@Autowired
	private LoginRepo loginRepo;
	
	public Login saveuser(Login user) {
		return loginRepo.save(user);
	}
	public Login fetchuserId(String useremail) {
		return loginRepo.findByUseremail(useremail);
	}
	public Login fetchuserIdAndPassword(String useremail,Integer password) {
		return loginRepo.findByUseremailAndPassword(useremail, password);	
	}

	public List<Login> userIdAndPassword() {
		// TODO Auto-generated method stub
		return null;
	}
}