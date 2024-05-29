package org.comstudy.day06.shop;

import java.util.Objects;

public class ProductDTO {
	private int seq;
	private String title;
	private int price;
	private String maker;
	private int ea;
	
	public ProductDTO() {
		// 디폴트 생성자에서 다른 생성자 호출
		// 널포인터 예외 발생 방지용 초기 값 설정
		this(0,"",0,"",0);
	}
	
	public ProductDTO(int seq) {
		this(seq,"",0,"",0);
	}

	public ProductDTO(int seq, String title, int price, String maker, int ea) {
		this.seq = seq;
		this.title = title;
		this.price = price;
		this.maker = maker;
		this.ea = ea;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	@Override
	public String toString() {
		return "ProductDTO [seq=" + seq + ", title=" + title + ", price=" + price + ", maker=" + maker + ", ea=" + ea
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(seq);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		return seq == other.seq;
	}
	
	public ProductDTO clone() {
		ProductDTO product  = new ProductDTO(seq, title, price, maker, ea);
		return product;
	}
}
