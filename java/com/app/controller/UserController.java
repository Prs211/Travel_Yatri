package com.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.ContactUs;
import com.app.pojos.Feedback;
import com.app.pojos.Packages;
import com.app.pojos.Payment;
import com.app.pojos.Users;
import com.app.service.UserServiceInterface;
import com.app.utility.BookingEmail;

@Controller
@RequestMapping("/User")
public class UserController {

	@Autowired
	private UserServiceInterface userService;

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/myprofile")
	public String showprofile() {
		return "/User/myprofile";
	}

	@GetMapping("/mybookings")
	public String showmyBookings(HttpSession hs) {
		Users user = (Users) hs.getAttribute("userDetails");
		hs.setAttribute("bookings", userService.fetchmyBookings(user));
		return "/User/mybookings";
	}

	@GetMapping("/bookPackage")
	public String showPayment(@RequestParam int pid, HttpSession hs) {
		Users user = (Users) hs.getAttribute("userDetails");
		hs.setAttribute("package1", userService.fetchPackageByID(pid));
		return "/User/payment";
	}

	@PostMapping("/bookSeat")
	public String processPayment(RedirectAttributes flashMap, @RequestParam String sdate, @RequestParam String edate,
			@RequestParam String ptype, HttpSession hs,Model modelMap) {
		hs.setAttribute("sdate", sdate);
		hs.setAttribute("edate", edate);
		Users user = (Users) hs.getAttribute("userDetails");
		Packages pac = (Packages) hs.getAttribute("package1");
		hs.setAttribute("pac2", pac);
		if (ptype.equals("Cash")) {
		
			flashMap.addFlashAttribute("message",
					userService.bookticket(user, pac, ptype, pac.getDiscount(), sdate, edate));
			return "redirect:/User/mybookings";
		} else {
		modelMap.addAttribute("message", "Please provide Card Detials to confirm your Booking");
			return "/User/pay";
		}
	}
	@PostMapping("/pay")
	public String processPayment(HttpSession hs,@RequestParam String name,@RequestParam String cvv,@RequestParam String date,@RequestParam String card,RedirectAttributes flashMap) {
		String sdate=(String) hs.getAttribute("sdate");
		String edate=(String) hs.getAttribute("edate");
		Users user = (Users) hs.getAttribute("userDetails");
		Packages pac = (Packages) hs.getAttribute("pac2");
		Payment p=new Payment(card, name, date, cvv);
		userService.savePayment(p);
		flashMap.addFlashAttribute("message",
				userService.booktickets(user, pac, "Card", pac.getDiscount(), sdate, edate));
		BookingEmail Bem=new BookingEmail();
		Bem.sendEmail(user.getEmail(), pac.getTitle());
		
		return "redirect:/User/mybookings";
	}
	

	@GetMapping("/contactus")
	public String contactus() {
		return "/User/contactus";
	}

	@PostMapping("/contactus")
	public String processContactus(RedirectAttributes flashMap, @RequestParam String name, @RequestParam String email,
			@RequestParam String mobile, @RequestParam String comment) {
		ContactUs c = new ContactUs(name, email, mobile, comment);
		flashMap.addFlashAttribute("message", userService.addContactUs(c));
		return "redirect:/User/contactus";
	}

	@GetMapping("/changepassword")
	public String changePassword() {
		return "/User/changepassword";
	}

	@PostMapping("/updatepassword")
	public String changePassword(HttpSession hs, @RequestParam String cpassword, @RequestParam String newpassword,
			RedirectAttributes flashMap) {
		Users user = (Users) hs.getAttribute("userDetails");
		if (user.getPassword().equals(cpassword)) {
			flashMap.addFlashAttribute("message", userService.changePassword(user.getId(), newpassword));
			return "redirect:/User/changepassword";
		} else {
			flashMap.addFlashAttribute("message", "Current Password is wrong");
			return "redirect:/User/changepassword";
		}
	}

	@GetMapping("/feedback")
	public String showFeedBack() {
		return "/User/feedback";
	}

	@PostMapping("/feedback")
	public String processFeedback(@RequestParam String name, @RequestParam String feedback, @RequestParam int rating,
			@RequestParam MultipartFile image, RedirectAttributes flashMap) throws IOException {
		byte[] imageFile = image.getBytes();
		Feedback feedback1 = new Feedback(name, feedback, imageFile, rating);
		flashMap.addFlashAttribute("message", userService.addFeedBack(feedback1));
		return "redirect:/User/feedback";
	}
}
