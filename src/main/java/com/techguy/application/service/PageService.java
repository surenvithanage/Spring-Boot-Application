package com.techguy.application.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.techguy.application.model.Page;

public interface PageService {
	ResponseEntity<Page> addPage(Page page);
	List<Page> getAllPages();
	ResponseEntity<Page> getPage(int id);
	ResponseEntity<String> deletePage(int id);
	ResponseEntity<String> deleteAll();
	ResponseEntity<Page> updatePage(int id , Page page);
}
