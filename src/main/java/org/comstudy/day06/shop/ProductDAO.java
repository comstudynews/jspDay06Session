package org.comstudy.day06.shop;

import java.util.List;

public interface ProductDAO {

	// CRUD (입력, 출력, 검색, 수정, 삭제)
	void insert(ProductDTO dto);

	List<ProductDTO> selectAll();

	ProductDTO findBySeq(int seq);

	void update(ProductDTO dto);

	void delete(ProductDTO dto);

}