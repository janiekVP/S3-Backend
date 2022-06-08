package com.backend.ItemTracker.service;

import com.backend.ItemTracker.model.Collection;
import com.backend.ItemTracker.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CollectionService {
    private final CollectionRepository collectionRepository;

    @Autowired
    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
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
