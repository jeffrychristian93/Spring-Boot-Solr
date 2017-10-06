package sample.data.solr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.data.solr.model.Product;
import sample.data.solr.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("product")
public class ExampleAPI {

    private final ProductRepository productRepository;

    @Autowired
    public ExampleAPI(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity<String>("hello !", HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<Product> add(@RequestBody Product product){
//        { "id":"P123", "name":"Product One" }
//        final Product product = new Product();
//        product.setId("P000089998");
//        product.setName("Desk");
        productRepository.save(product);
        return new ResponseEntity<Product>(productRepository.findById(product.getId()).get(), HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity<Product> update(@RequestBody Product product){
//        final Product product = new Product();
//        product.setId("P0001");
//        product.setName("T-Shirt");

        productRepository.save(product);

        product.setName("Shirt");
        productRepository.save(product);

//        return ResponseEntity.ok(productRepository.findById(product.getId()).get());
        return new ResponseEntity<Product>(productRepository.findById(product.getId()).get(), HttpStatus.OK);
    }


    @DeleteMapping("delete")
    public ResponseEntity<Product> delete(){
        final Product product = new Product();
        product.setId("P0001");
        product.setName("Desk");
        productRepository.save(product);
        productRepository.delete(product);
        return new ResponseEntity<>(productRepository.findById(product.getId()).get(), HttpStatus.OK);
    }

    @GetMapping("findbyname/{name}")
    public ResponseEntity<List<Product>> findByName(@PathVariable("name") String name){
        Product phone = new Product();
        phone.setId("P0001");
        phone.setName("Phone");
        productRepository.save(phone);

        return new ResponseEntity<>(productRepository.findByName(name), HttpStatus.OK);
    }

    @GetMapping("findbyquery/{query}")
    public ResponseEntity<Page<Product>> findByQuery(@PathVariable("query") String query){
        final Product phone = new Product();
        phone.setId("P0001");
        phone.setName("Smart Phone");
        productRepository.save(phone);

        final Product phoneCover = new Product();
        phoneCover.setId("P0002");
        phoneCover.setName("Phone Cover");
        productRepository.save(phoneCover);

        final Product wirelessCharger = new Product();
        wirelessCharger.setId("P0003");
        wirelessCharger.setName("Phone Charging Cable");
        productRepository.save(wirelessCharger);

        Page<Product> result = productRepository.findByCustomQuery(query, PageRequest.of(0, 10));

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("findbynamedquery/{query}")
    public ResponseEntity<Page<Product>> findByNamedQuery(@PathVariable("query") String query) {
        final Product phone = new Product();
        phone.setId("P0001");
        phone.setName("Smart Phone");
        productRepository.save(phone);

        final Product phoneCover = new Product();
        phoneCover.setId("P0002");
        phoneCover.setName("Phone Cover");
        productRepository.save(phoneCover);

        final Product wirelessCharger = new Product();
        wirelessCharger.setId("P0003");
        wirelessCharger.setName("Phone Charging Cable");
        productRepository.save(wirelessCharger);

        Page<Product> result = productRepository.findByNamedQuery(query, PageRequest.of(0, 10));
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
