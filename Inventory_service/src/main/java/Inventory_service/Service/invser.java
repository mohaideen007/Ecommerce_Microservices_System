package Inventory_service.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Inventory_service.Model.inventory_dao;
import Inventory_service.Repo.Inventory_repo;

@Service
public class invser {

    @Autowired
    private Inventory_repo invrep;

    public inventory_dao addamount(inventory_dao inventory) {

        invrep.save(inventory);
       return inventory;
    }

    public int checkquantity(String itemName) {

        inventory_dao invendao=invrep.findByItemName(itemName);



        if(invendao!=null){
            return invendao.getItemQuantity();
        }

       return 0;
    }

}
