package com.techguy.application.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techguy.application.model.Page;
import com.techguy.application.repository.PageRepository;
import com.techguy.application.service.PageService;

@Service
public class PageServiceImpl implements PageService {

	@Autowired
	PageRepository pageRepository;

	@Override
	public ResponseEntity<Page> addPage(Page page) {
		try {
			pageRepository.save(page);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(page, HttpStatus.OK);
	}

	@Override
	public List<Page> getAllPages() {
		List<Page> page = new ArrayList<>();
		try {
			pageRepository.findAll().forEach(page::add);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (page.size() > 0)
			return page;
		else
			return null;
	}

	@Override
	public ResponseEntity<Page> getPage(int id) {
		Page page = new Page();
		try {
			Optional<Page> pageData = pageRepository.findById(id);
			if (pageData.isPresent()) {
				page = pageData.get();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(page, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<String> deletePage(int id) {
		try {
			pageRepository.deleteById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("Unsuccessful to delete page : " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully deleted the page : " + id, HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<String> deleteAll() {
		try {
			pageRepository.deleteAll();
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>("Unsuccessful to delete all pages : ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Successfully deleted all pages : ", HttpStatus.FOUND);
	}

	@Override
	public ResponseEntity<Page> updatePage(int id, Page page) {
		Optional<Page> pageData = pageRepository.findById(id);
		if(pageData.isPresent()) {
			Page pageinfo = pageData.get();
			pageinfo.setName(page.getName());
			pageinfo.setCategory(page.getCategory());
			pageinfo.setDescription(page.getDescription());
			pageinfo.setUrl(page.getDescription());
			return new ResponseEntity<>(pageRepository.save(pageinfo) , HttpStatus.FOUND);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

}
