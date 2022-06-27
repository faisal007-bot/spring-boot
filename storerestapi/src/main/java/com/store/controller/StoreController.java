package com.store.controller;

import com.store.model.Store;
import com.store.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("/product")
    public ResponseEntity<Store> saveStore(@RequestBody Store store) {
        Store store1 = storeService.addStore(store);
        return new ResponseEntity<>(store1, HttpStatus.CREATED);
    }

    @PostMapping("/products")
    public ResponseEntity<List<Store>> saveStores(@RequestBody List<Store> stores) {
        List<Store> stores1 = storeService.addStores(stores);
        return new ResponseEntity<>(stores1, HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Store> updateStore(@RequestBody Store store, @PathVariable int id) {
        store.setId(id);
        Store store1 = storeService.updateStore(store);
        return new ResponseEntity<>(store1, HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
        return new ResponseEntity<>("product has been deleted", HttpStatus.OK);
    }

    @DeleteMapping("/products")
    public ResponseEntity<?> deleteStores(@RequestParam("ids") List<Integer> ids) {
        storeService.deleteStores(ids);
        return new ResponseEntity<>("all the stores has been deleted", HttpStatus.OK);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Store> getStore(@PathVariable int id) {
        Store store = storeService.getStore(id);
        return new ResponseEntity<>(store, HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<List<Store>> getStores(@RequestParam("ids") List<Integer> ids) {
        List<Store> stores = storeService.getStores(ids);
        return new ResponseEntity<>(stores, HttpStatus.OK);
    }

    @GetMapping("/products/all")
    public ResponseEntity<List<Store>> getAllStores() {
        List<Store> allStores = storeService.getAllStores();
        return new ResponseEntity<>(allStores, HttpStatus.OK);
    }
}
