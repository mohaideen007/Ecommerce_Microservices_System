package Inventory_service.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import Inventory_service.Model.inventory_dao;

public interface Inventory_repo extends JpaRepository<inventory_dao,Long >{

    inventory_dao findByItemName(String itemName);

}
