package com.backend.ItemTracker.service;

import com.backend.ItemTracker.model.Collection;
import com.backend.ItemTracker.model.Item;
import com.backend.ItemTracker.model.User;
import com.backend.ItemTracker.repository.CollectionRepository;
import com.backend.ItemTracker.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollectionService {
    private final CollectionRepository collectionRepository;

    @Autowired
    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Collection> GetAll() {
        List<Collection> collections = collectionRepository.findAll();
        return collections;
    }

    public Collection FindCollectionById(Long id) {
        Collection collection = collectionRepository.findById(id).get();
        return collection;
    }

    public Collection Create(Collection collection) {
        Collection savedCollection = collectionRepository.save(collection);
        return savedCollection;
    }

    public Collection Update(Collection collection) {
        Collection savedCollection = collectionRepository.save(collection);
        return savedCollection;
    }

    public void Delete(Long id) {
        collectionRepository.deleteById(id);
    }
}
