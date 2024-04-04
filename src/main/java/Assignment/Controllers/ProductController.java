package Assignment.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Assignment.Entities.InventoryStatus;
import Assignment.Services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/inventory")
    public ResponseEntity<Object> getInventory() {
        try{
            InventoryStatus result = productService.getInventory();
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Error retrieving inventory: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
