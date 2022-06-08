package com.backend.ItemTracker.controller;

import com.backend.ItemTracker.model.Item;
import com.backend.ItemTracker.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;
    @Autowired
    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems(){
        List<Item> itemList = itemService.GetAll();
        return ResponseEntity.ok(itemList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getItem(@PathVariable Long id) {
        Item item = itemService.FindItemById(id);
        return ResponseEntity.ok(item);
        //return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createItem(@RequestBody Item item) throws URISyntaxException {
        Item savedItem = itemService.Create(item);
        return ResponseEntity.created(new URI("/items/" + savedItem.getId())).body(savedItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable Long id, @RequestBody Item item) {
        Item currentItem = itemService.FindItemById(id);//.orElseThrow(RuntimeException::new);
        currentItem.setName(item.getName());
        currentItem.setDescription(item.getDescription());

        Item updatedItem = itemService.Update(currentItem);

        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        itemService.Delete(id);
        return ResponseEntity.ok().build();
    }
}
