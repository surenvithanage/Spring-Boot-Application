package com.techguy.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techguy.application.model.Page;

@Repository
public interface PageRepository extends CrudRepository<Page, Integer>{
	Page findByCategory(String category);
	Page findByName(String name);
}
