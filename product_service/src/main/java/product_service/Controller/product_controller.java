package product_service.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import product_service.Model.product_dao;
import product_service.Service.product_servcie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/product")
public class product_controller {



    @Autowired
    private product_servcie proser;

    @PostMapping("/addproduct")
    public product_dao addprod(@RequestBody product_dao prod) {
     
        
        return proser.addproduct(prod);
    }
    
    @GetMapping("/checkavailable/{productName}")
    public String checky(@PathVariable String productName) {
    	
    	
		return proser.check(productName);
    	
    }
    
    
    

}
