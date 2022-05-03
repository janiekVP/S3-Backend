package com.backend.ItemTracker.service;

import com.backend.ItemTracker.model.Item;
import com.backend.ItemTracker.model.User;
import com.backend.ItemTracker.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> GetAll() {
        List<Item> items = itemRepository.findAll();
        return items;
    }

    public Item FindItemById(Long id) {
        Item item = itemRepository.findById(id).get();
        return item;
    }

    public Item Create(Item item) {
        Item savedItem = itemRepository.save(item);
        return savedItem;
    }

    public Item Update(Item item) {
        Item savedItem = itemRepository.save(item);
        return savedItem;
    }

    public void Delete(Long id) {
        itemRepository.deleteById(id);
    }
}
