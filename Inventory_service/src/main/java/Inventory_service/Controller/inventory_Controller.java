package Inventory_service.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Inventory_service.Model.inventory_dao;
import Inventory_service.Service.invser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/inventory")
public class inventory_Controller {


    @Autowired
    private invser invs;


    @PostMapping("/addquantity")
    public inventory_dao addquantity(@RequestBody inventory_dao inventory) {
        return invs.addamount(inventory);
}

@GetMapping("/checkquantity/{itemName}")
public int getMethodName(@PathVariable("itemName") String itemName ) {
    return invs.checkquantity(itemName);
}

}
