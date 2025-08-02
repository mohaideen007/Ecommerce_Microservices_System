package product_service.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import product_service.Model.product_dao;

public interface product_repo extends JpaRepository<product_dao,Long> {


     product_dao findByProductName(String productName);

}
