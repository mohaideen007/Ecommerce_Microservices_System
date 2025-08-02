package cart_service.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import cart_service.Model.cart_dao;
import cart_service.Repository.cart_repo;
import reactor.core.publisher.Mono;

@Service
public class cart_service {

	@Autowired
	private cart_repo carrepo;

	@Autowired
	private WebClient.Builder webClientBuilder;
	
	public cart_service(WebClient.Builder webClientBuilder) {
		this.webClientBuilder=webClientBuilder;
	}
	
	
	public String add(cart_dao cart){//int userId,String itemname) {
		System.out.println("DEBUG: Received itemname = "+ cart.getItemname());//itemname);
		
		String  ans=webClientBuilder.build().get()
				.uri("http://product-service/product/checkavailable/"+cart.getItemname())//
					.retrieve()
					.bodyToMono(String.class)
					.block();
		if("product available".equalsIgnoreCase(ans)) {
			cart_dao cart1=new cart_dao();
			cart1.setItemname(cart.getItemname());
			cart1.setUserId(cart.getUserId());
			carrepo.save(cart1);
			System.out.println(cart.getItemname());
	System.out.println(cart.getUserId());
		}
		
	
	return ans+" added to cart";
}


    public List<cart_dao> viewcart(int userId) {

		List<cart_dao> cart=carrepo.findByUserId(userId);

		return cart;
    }


    public List<cart_dao> getAllItems() {
      return carrepo.findAll();
    }





	
}
