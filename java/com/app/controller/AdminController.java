package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.pojos.Bookings;
import com.app.pojos.Images;
import com.app.pojos.Packages;
import com.app.pojos.Users;
import com.app.service.AdminServiceInterface;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AdminServiceInterface adminService;

	public AdminController() {
		System.out.println("in constr of " + getClass().getName());
	}

	@GetMapping("/Dashboard")
	public String showDahboard(HttpSession hs) {
		int count1=0;
		List<Images> list1=adminService.fetchAllImages();
		for(Images i:list1) {
			count1=count1+1;
		}
		hs.setAttribute("totalImages",count1);
		int count2=0;
		List<Packages> list2=adminService.fetchAllPackages();
		for(Packages p:list2) {
			count2=count2+1;
		}
		hs.setAttribute("totalPackages",count2 );
		int count3=0;
		List<Bookings> list3=adminService.fetchAllBooking();
		for(Bookings b:list3) {
			count3=count3+1;
		}
		hs.setAttribute("totalBookings", count3);
		int count4=0;
		List<Users> list4=adminService.FetchUsers();
		for(Users u:list4) {
			count4=count4+1;
		}
		hs.setAttribute("userCount",count4);
		return "/Admin/Dashboard";
	}

	@GetMapping("/userFeedback")
	public String userFeedback(HttpSession hs) {
		hs.setAttribute("feedback", adminService.fetchAllFeedback());
		return "/Admin/userFeedback";
	}

	@GetMapping("/watchBookings")
	public String watchBookings(HttpSession hs) {
		hs.setAttribute("booking", adminService.fetchAllBooking());
		return "/Admin/watchBookings";
	}

	@GetMapping("/contactUs")
	public String contactUs(HttpSession hs) {
		hs.setAttribute("contactus", adminService.fetchAllContactUs());
		return "/Admin/contactUs";
	}

	@GetMapping("/addImages")
	public String addImages(HttpSession hs) {
		hs.setAttribute("imageList", adminService.fetchAllImages());
		return "/Admin/addImages";
	}
	@GetMapping("/image_delete")
	public String deleteImage(@RequestParam int pid,RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("message", adminService.removeImage(pid));
		return "redirect:/Admin/addImages";
	}

	@PostMapping("/addImage")
	public String processAddImages(@RequestParam MultipartFile image, @RequestParam String description, HttpSession hs,
			RedirectAttributes flashMap) throws IOException{
	byte[] imageFile=image.getBytes();
	Images image1=new Images(imageFile, description);
		flashMap.addFlashAttribute("message", adminService.addImage(image1));
		return "redirect:/Admin/addImages";
	}
	@GetMapping("/addPackages")
	public String addPackages() {
		return "/Admin/addPackages";
	}

	@PostMapping("/addPackage")
	public String processaddPackage(HttpSession hs, RedirectAttributes flashMap, Model modelMap,
			@RequestParam String title, @RequestParam String details, @RequestParam String price,
			@RequestParam String discount, @RequestParam int rating, @RequestParam MultipartFile image) throws IOException {
		byte[] imageFile=image.getBytes();
		Packages package1=new Packages(title, details, price, discount, rating, imageFile);
		System.out.println(package1);
		flashMap.addFlashAttribute("message", adminService.addPackage(package1));
		return "redirect:/Admin/viewPackages";
	}

	@GetMapping("/viewPackages")
	public String viewPackages(HttpSession hs) {
		hs.setAttribute("packages", adminService.fetchAllPackages());
		return "/Admin/viewPackages";
	}
	@GetMapping("/package_delete")
	public String delete1Image(@RequestParam int pid,RedirectAttributes flashMap,Model modelMap) {
		try {
			flashMap.addFlashAttribute("message", adminService.deletePackage(pid));
			return "redirect:/Admin/viewPackages";
		} catch (Exception e) {
			modelMap.addAttribute("message", "Can not Delete the packages already booked by Customers");
			return "/Admin/viewPackages";
		}
	}
	@GetMapping("/updateBooking")
	public String updateBooking(@RequestParam int bid, RedirectAttributes flashMap,HttpSession hs) {
		hs.setAttribute("booking", adminService.fetchBookingById(bid));
	return "/Admin/updateBooking";
	}
	@PostMapping("/updateBooking")
	public String updateProcess(@RequestParam String startdate,@RequestParam String enddate,@RequestParam int bid,RedirectAttributes flashMap) {
		flashMap.addFlashAttribute("message", adminService.updatebooking(bid,startdate,enddate));
		return "redirect:/Admin/watchBookings";
	}
	}
