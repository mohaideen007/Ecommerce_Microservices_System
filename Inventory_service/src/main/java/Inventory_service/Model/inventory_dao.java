package Inventory_service.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class inventory_dao {




    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long itemId;


    private String itemName;
    private int itemQuantity;

}
