package com.backend.ItemTracker.repository;

import com.backend.ItemTracker.model.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Long>{
}
