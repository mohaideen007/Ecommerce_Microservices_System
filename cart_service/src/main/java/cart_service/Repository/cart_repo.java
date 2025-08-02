package cart_service.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cart_service.Model.cart_dao;

public interface cart_repo extends JpaRepository<cart_dao,Long> {

    List<cart_dao> findByUserId(int userId);
    
    

}
