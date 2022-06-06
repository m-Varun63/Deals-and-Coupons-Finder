package login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import login.model.Login;
import login.service.LoginService;

@CrossOrigin(origins="http://localhost:4200")

@RestController
@RequestMapping("/admin")
public class LoginController {
	
	/*@Autowired
	private LoginRepo loginRepo;
*/
	@GetMapping(value = "/list")
    public List<Login> getAllCoupons(){
        return loginService.userIdAndPassword();
    }

    /*@PostMapping(value = "/add")
    public String addCoupon(@RequestBody Login login){
    	loginService.save(login);
        return "Admin Added Succesfully";}*/
	
	@Autowired
	private LoginService loginService;

	@PostMapping("/login")
	@CrossOrigin(origins="http://localhost:4200")
	public Login loginUser(@RequestBody Login cre) throws Exception {
		String temp = cre.getUseremail();
		Integer password = cre.getPassword();
		Login cd= null;
		if(temp != null && password != null) {
		 cd = loginService.fetchuserIdAndPassword(temp, password);
		}
		if(cd == null) {
			throw new Exception("bad credential");
		}
		return cd;
	}

	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping("/getuser/{id}")
	public  Login getUser(@PathVariable String id ){
		return loginService.fetchuserId(id);
	}
}
