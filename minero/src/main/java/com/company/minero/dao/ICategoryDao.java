package com.company.minero.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.minero.model.Category;

public interface ICategoryDao extends  CrudRepository<Category, Long> {
}
