package order_service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class order_service {

    @Autowired
    private order_repo orrep;

    private WebClient webClient;


    @Autowired
    private JavaMailSender mailSender;

    public order_service(WebClient webClient){
        this.webClient=webClient;
    }
    public String placeorder() {

        List<order_dao> orderList = webClient.get()
        .uri("http://localhost:8082/cart/allitems")
        .retrieve()
        .bodyToFlux(order_dao.class)
        .collectList()
        .block();


    
        for (order_dao orderlist : orderList) {
            int quantity=webClient.get()
            .uri("http://localhost:8084/inventory/checkquantity/"+orderlist.getItemname())
            .retrieve()
            .bodyToMono(Integer.class)
            .block();
            
            if(quantity>0){

                 order_dao ordao=new order_dao();
                 ordao.setItemname(orderlist.getItemname());
                 ordao.setUserId(orderlist.getUserId());

                 orrep.save(ordao);

                 return "Order placed for item: " + orderlist.getItemname() + " for user: " + orderlist.getUserId();
            }
            else{
                return orderlist.getItemname()+" out of stock";
        }
    }
        return "No items in cart";
        
    }

    public String sendEmail(email_dao emaildao) {


        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(emaildao.getTo());
        mailMessage.setSubject(emaildao.getSubject());
        mailMessage.setText(emaildao.getBody());
        mailMessage.setFrom("mohaideensheik777@gmail.com");

        System.out.println(emaildao.getTo());
        System.out.println(emaildao.getSubject());

        mailSender.send(mailMessage);
        return "email Sent successfully";
        
    }

}
