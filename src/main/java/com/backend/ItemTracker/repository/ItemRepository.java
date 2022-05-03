package com.backend.ItemTracker.repository;

import com.backend.ItemTracker.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
