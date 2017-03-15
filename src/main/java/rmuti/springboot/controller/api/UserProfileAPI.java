package rmuti.springboot.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rmuti.springboot.controller.APIResponse;
import rmuti.springboot.db.service.UserProfileDao;
import rmuti.springboot.db.table.UserProfile;

@RestController
@RequestMapping("/userprofile")
public class UserProfileAPI {

	@Autowired
	private UserProfileDao userProfileDAO;

	@RequestMapping(value = "/create", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
	public Object addProduct(@RequestParam(name = "user_name") String userName,
			@RequestParam(name = "pass_word") String passWord) {
		APIResponse res = new APIResponse();
		UserProfile userProfile = new UserProfile();
		userProfile.setUserName(userName);
		userProfile.setPassWord(passWord);
		userProfileDAO.save(userProfile);
		return res;
	}

	@RequestMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, method = { RequestMethod.POST,
			RequestMethod.GET })
	public Object test() {
		APIResponse res = new APIResponse();
		res.setStatus(1);
		res.setMessage("test");
		return res;
	}
}
