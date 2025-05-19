package com.company.minero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.minero.dao.ICategoryDao;
import com.company.minero.model.Category;
import com.company.minero.response.CategoryResponseRest;

@Service
public class CategoryServiceImpl implements ICateoryService {

	@Autowired
	private ICategoryDao categoryDao;

	@Override
	@Transactional(readOnly = true)
	public ResponseEntity<CategoryResponseRest> search() {

		CategoryResponseRest response = new CategoryResponseRest();

		try {
			List<Category> category = (List<Category>) categoryDao.findAll();
			response.getCategoryResponse().setCategory(category);
			response.setMetadata("respuesta ok", "00", "respuesta exitosa");

		} catch (Exception e) {
			response.setMetadata("respuesta nok", "-1", "error al consultar");
			e.getStackTrace();

			return new ResponseEntity<CategoryResponseRest>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<CategoryResponseRest>(HttpStatus.OK);
	}
}
