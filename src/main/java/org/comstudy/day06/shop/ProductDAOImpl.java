package org.comstudy.day06.shop;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
	private static final List<ProductDTO> productList;
	private static int seq;
	static {
		productList = new ArrayList<ProductDTO>();
		productList.add(new ProductDTO(1, "냉장고", 300, "삼성", 0));
		productList.add(new ProductDTO(2, "세탁기", 100, "LG", 0));
		productList.add(new ProductDTO(3, "선풍기", 30, "삼성", 0));
		productList.add(new ProductDTO(4, "컴퓨터", 160, "ASUS", 0));
		productList.add(new ProductDTO(5, "테레비", 200, "LG", 0));
		productList.add(new ProductDTO(6, "에어컨", 250, "케리어", 0));
		seq = 7;
	}
	
	// CRUD (입력, 출력, 검색, 수정, 삭제)
	@Override
	public void insert(ProductDTO dto) {
		dto.setSeq(seq++);
		productList.add(dto);
	}
	
	@Override
	public List<ProductDTO> selectAll() {
		return productList;
	}
	
	private int findIndex(int seq) {
		int idx = -1;
		for(int i=0; i<productList.size(); i++) {
			if(productList.get(i).getSeq() == seq) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
	@Override
	public ProductDTO findBySeq(int seq) {
		ProductDTO product = null;
		int i = findIndex(seq);
		if(i != -1) {
			product = productList.get(i);
		}
		
		return product;
	}
	
	@Override
	public void update(ProductDTO dto) {
		int i = findIndex(dto.getSeq());
		if(i != -1) {
			productList.set(i, dto);
		}
	}
	
	@Override
	public void delete(ProductDTO dto) {
		int i = findIndex(dto.getSeq());
		if(i != -1) {
			productList.remove(i);
		}
	}
}
