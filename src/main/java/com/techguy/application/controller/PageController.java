package com.techguy.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.techguy.application.model.Page;
import com.techguy.application.repository.PageRepository;
import com.techguy.application.service.PageService;

@RestController
@RequestMapping("/page")
public class PageController {

	private PageService pageService;
	private PageRepository pageRepository;

	@Autowired
	public PageController(PageService pageService, PageRepository pageRepository) {
		this.pageRepository = pageRepository;
		this.pageService = pageService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public ResponseEntity<Page> add(@Valid @RequestBody Page page) {
		return pageService.addPage(page);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
	public ResponseEntity<String> deletePage(@PathVariable int id) {
		return pageService.deletePage(id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/delete")
	public ResponseEntity<String> deleteAllPages() {
		return pageService.deleteAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public List<Page> getAllPages() {
		return pageService.getAllPages();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list/{id}")
	public ResponseEntity<Page> getPage(@PathVariable int id) {
		return pageService.getPage(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
	public ResponseEntity<Page> updatePage(@Valid @PathVariable int id, @RequestBody Page page) {
		return pageService.updatePage(id, page);
	}

	@RequestMapping(method = RequestMethod.GET , value = "/category/{category}")
	public ResponseEntity<Page> findByCategory(@PathVariable String category) {
		Page page = null;
		try {
			page = pageRepository.findByCategory(category);
			if (page != null) {
				return new ResponseEntity<>(page, HttpStatus.OK);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(method = RequestMethod.GET , value = "/name/{name}")
	public ResponseEntity<Page> findByName(@PathVariable String name) {
		Page page = null;
		try {
			page = pageRepository.findByCategory(name);
			if (page != null) {
				return new ResponseEntity<>(page, HttpStatus.OK);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
