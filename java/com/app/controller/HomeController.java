package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Admin;
import com.app.pojos.Users;
import com.app.service.AdminServiceInterface;
import com.app.service.LoginServiceInterface;
import com.app.utility.OTPSender;
import com.app.utility.Utility;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private LoginServiceInterface loginService;

	@Autowired
	private AdminServiceInterface adminService;

	public HomeController() {
		System.out.println("In constr of " + getClass().getName());
	}

	@GetMapping("/")
	public String showIndex(HttpSession hs) {
		Admin admin = loginService.checkAdminAvailablity();
		if (admin != null) {

		} else {
			Admin admin1 = new Admin("Travel Yatri", "admin@gmail.com", "1234", "9923587609");
			loginService.registerAdmin(admin1);
		}
		hs.setAttribute("packages", adminService.fetchAllPackages());
		hs.setAttribute("imageList", adminService.fetchAllImages());
		hs.setAttribute("feedBackList", adminService.fetchAllFeedBack());

		return "/index";
	}

	@PostMapping("/login")
	public String VerifyUser(@RequestParam String email, @RequestParam String password, HttpSession hs, Model modelMap,
			RedirectAttributes flashMap) {
		Users user = loginService.verifyUser(email, password);
		Admin admin = loginService.verifyAdmin(email, password);
		if (user != null) {
			hs.setAttribute("userDetails", user);
			return "redirect:/";
		} else if (admin != null) {
			hs.setAttribute("userDetails", admin);
			return "redirect:/Admin/Dashboard";
		} else {
			flashMap.addFlashAttribute("message", "Invalid Cradentials");
			return "redirect:/";
		}
	}

	@GetMapping("/signup")
	public String showSignUp() {
		return "/signup";
	}

	@PostMapping("/signup")
	public String registerUser(HttpSession hs, Model modelMap, RedirectAttributes flashMap,
			@RequestParam String last_name, @RequestParam String first_name, @RequestParam String email,
			@RequestParam String mobile, @RequestParam String password, @RequestParam String cpassword) {
		if (password.equals(cpassword)) {
			Users user = new Users(first_name + " " + last_name, email, mobile, password, "Live");
			if (loginService.checkEmailAvailable(email)) {
				flashMap.addFlashAttribute("umessage", loginService.registerUser(user));
				return "redirect:/";
			} else {
				flashMap.addFlashAttribute("message", "Email Already Taken");
				return "redirect:/signup";
			}

		} else {
			flashMap.addFlashAttribute("message", "Confirm Password not Matched With Password");
			return "redirect:/signup";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession hs) {
		hs.getAttribute("userDetails");
		hs.invalidate();
		return "redirect:/";
	}

	@GetMapping("/forgetpassword")
	public String forgetPassword() {
		return "/forgetpassword";
	}

	@PostMapping("/forgetpassword")
	public String getOtp(@RequestParam String email, Model modelMap, HttpSession hs) {
		hs.setAttribute("email", email);
		int otp = Utility.generateOTP();
		hs.setAttribute("otp", otp);
		OTPSender op = new OTPSender();
		op.sendEmail(email, otp);
		return "/forgetpassword";
	}

	@PostMapping("/otpverify")
	public String verifyOpt(@RequestParam int otp, HttpSession hs, Model modelMap,RedirectAttributes flashMap) {
		int otp1 = (int) hs.getAttribute("otp");
		if (otp1 != otp) {
			flashMap.addFlashAttribute("message", "Invalid Otp");
			return "redirect:/forgetpassword";
		} else {
			
			return "/changePassword";
		}
	}
	@PostMapping("/changepassword")
	public String changepassword(@RequestParam String password,HttpSession hs,Model modelMap) {
		String email=(String) hs.getAttribute("email");
		modelMap.addAttribute("message",loginService.changePassword(email,password));
		return "redirect:/";
	}

}
