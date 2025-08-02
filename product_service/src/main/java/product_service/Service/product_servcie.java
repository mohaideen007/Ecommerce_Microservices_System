package product_service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import product_service.Model.product_dao;
import product_service.Repository.product_repo;

@Service
public class product_servcie {

    @Autowired
    private product_repo prorepo;

    public product_dao addproduct(product_dao prod) {
        prorepo.save(prod);
      return prod;
    }

	public String check(String productName) {
		
		product_dao prodao=prorepo.findByProductName(productName);
		if(prodao.getproductName()!=null && prodao.getQuantity()>0){
      return "product available";
    }
    else{
      return "product not available";
    }

	}

	

}
