package com.store.service;

import com.store.model.Store;
import com.store.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {
    @Autowired
    private StoreRepository storeRepository;

    public Store addStore(Store store) {
        Store store1 = storeRepository.saveAndFlush(store);
        return store1;
    }

    public List<Store> addStores(List<Store> stores) {
        List<Store> stores1 = storeRepository.saveAllAndFlush(stores);
        return stores1;
    }

    public Store updateStore(Store store) {
        Store store1 = storeRepository.saveAndFlush(store);
        return store1;
    }

    public void deleteStore(int storeId) {
        storeRepository.deleteById(storeId);
    }

    public void deleteStores(List<Integer> ids) {
        storeRepository.deleteAllById(ids);
    }

    public Store getStore(int storeId) {
        Store store = storeRepository.findById(storeId).get();
        return store;
    }

    public List<Store> getStores(List<Integer> ids) {
        List<Store> stores = storeRepository.findAllById(ids);
        return stores;
    }

    public List<Store> getAllStores() {
        List<Store> stores = storeRepository.findAll();
        return stores;
    }
}
