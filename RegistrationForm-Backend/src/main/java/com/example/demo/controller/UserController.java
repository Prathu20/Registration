package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository repo;
	
	@RequestMapping("/")
	public String home(Model model) {
		User user = new User();
	    model.addAttribute("user", user); 
		return "index";
	}
	
	@PostMapping("/register")
	public String home(@ModelAttribute User u, @RequestParam("imageUrl") MultipartFile file) {
	    try {
	        // Process the uploaded file only if it's not empty
	    	if (!file.isEmpty()) {
                // Convert MultipartFile to byte[]
                byte[] bytes = file.getBytes();
                
                User user=new User();
				// Set the byte[] to imagesData
                user.setImagesData(bytes);
                user.setFirstName(u.getFirstName());
                user.setLastName(u.getLastName());
                user.setGender(u.getGender());
                user.setEducation(u.getEducation());
                user.setCountry(u.getCountry());
                user.setState(u.getState());
                user.setCity(u.getCity());
                user.setDescription(u.getDescription());

                // Optionally, you can also set the Base64 version for display purposes
//                String base64EncodedImage = Base64.getEncoder().encodeToString(bytes);
//                user.setBase64Content(base64EncodedImage); // for displaying in a view or testing
                repo.save(user);
                
            }	    	

	    } catch (Exception e) {
	        e.printStackTrace();
	        return "error";  // Return an error page in case of failure
	    }
	    return "index";  // Return the success page or index
	}

	@GetMapping("/home")
	public String showUser(Model model) {
	    List<User> users = repo.findAll(Sort.by(Sort.Direction.DESC,"id"));	
	    for (User user : users) {
            if (user.getImagesData() != null) {
                String base64Image = Base64.getEncoder().encodeToString(user.getImagesData());
                user.setBase64Content(base64Image);  // Set the Base64 string for use in the view
            }
        }

        // Add the users to the model       
	    model.addAttribute("users", users);
	    return "home";
	}
	

	
}
