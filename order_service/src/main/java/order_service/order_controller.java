package order_service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/order")
public class order_controller {

    @Autowired
    private order_service ordser;



    @PostMapping("/place")
    public String postMethodName() {
        
        
        return ordser.placeorder();
    }


    @PostMapping("/sendemail")
    public String sendEmail(@RequestBody email_dao emaildao) {
        return ordser.sendEmail(emaildao);
    }

    
    
    






}
