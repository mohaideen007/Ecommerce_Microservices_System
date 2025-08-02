package order_service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface order_repo extends JpaRepository<order_dao, Long> {
    

}
