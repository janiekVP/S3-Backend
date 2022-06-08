package com.backend.ItemTracker.controller;

import com.backend.ItemTracker.model.Collection;
import com.backend.ItemTracker.model.Item;
import com.backend.ItemTracker.model.User;
import com.backend.ItemTracker.service.CollectionService;
import com.backend.ItemTracker.service.ItemService;
import com.backend.ItemTracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/collections")
public class CollectionController {
    private final CollectionService collectionService;
    @Autowired
    public CollectionController(CollectionService collectionService){
        this.collectionService = collectionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity getCollection(@PathVariable Long id) {
        Collection collection = collectionService.FindCollectionById(id);
        return ResponseEntity.ok(collection);
        //return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createCollection(@RequestBody Collection collection) throws URISyntaxException {
        Collection savedCollection = collectionService.Create(collection);
        return ResponseEntity.created(new URI("/collections/" + savedCollection.getId())).body(savedCollection);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCollection(@PathVariable Long id, @RequestBody Collection collection) {
        Collection currentCollection = collectionService.FindCollectionById(id);//.orElseThrow(RuntimeException::new);

        Collection updatedCollection = collectionService.Update(currentCollection);

        return ResponseEntity.ok(updatedCollection);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        collectionService.Delete(id);
        return ResponseEntity.ok().build();
    }
}

