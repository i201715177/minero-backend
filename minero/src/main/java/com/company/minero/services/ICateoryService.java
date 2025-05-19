package com.company.minero.services;

import org.springframework.http.ResponseEntity;

import com.company.minero.response.CategoryResponseRest;

public interface ICateoryService {

	
	public ResponseEntity<CategoryResponseRest> search();
}
