package cart_service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cart_service.Model.cart_dao;
import cart_service.Service.cart_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/cart")
public class cart_controller {
	
	
	@Autowired
	private cart_service cartser;
	
	@PostMapping("/additem")
	    @PreAuthorize("hasRole('USER')")

	public String addy(@RequestBody cart_dao cart)//@PathVariable int userId,@PathVariable  String itemname) 
	{
		return cartser.add(cart);//userId,itemname);
		
	}

	@GetMapping("/viewcart/{id}")
	public List<cart_dao> viewcart(@PathVariable("id") int userId){
		return cartser.viewcart(userId);
	}


	@GetMapping("/allitems")
	public List<cart_dao> getAllItems() {
		return cartser.getAllItems();
	}

}
