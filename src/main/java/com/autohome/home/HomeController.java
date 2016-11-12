package com.autohome.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Principal principal) {

		return addNum(1, 2) > 2 && principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}

	public int addNum(int t1, int t2) {
		return t1 + t2;
	}
}
