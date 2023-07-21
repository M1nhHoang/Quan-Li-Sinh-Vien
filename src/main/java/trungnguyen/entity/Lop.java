package trungnguyen.entity;

import java.util.Date;

public class Lop {
	private int maLop;
	private String tenLop;
	private Date ngayBatDau;
	private Date ngayKetThuc;
	
	public Lop() {
		// TODO Auto-generated constructor stub
	}
	
	public Lop(int maLop, String tenLop, Date ngayBatDau, Date ngayKetThuc) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
		this.ngayBatDau = ngayBatDau;
		this.ngayKetThuc = ngayKetThuc;
	}

	public int getMaLop() {
		return maLop;
	}

	public void setMaLop(int maLop) {
		this.maLop = maLop;
	}

	public String getTenLop() {
		return tenLop;
	}

	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public Date getNgayBatDau() {
		return ngayBatDau;
	}

	public void setNgayBatDau(Date ngayBatDau) {
		this.ngayBatDau = ngayBatDau;
	}

	public Date getNgayKetThuc() {
		return ngayKetThuc;
	}

	public void setNgayKetThuc(Date ngayKetThuc) {
		this.ngayKetThuc = ngayKetThuc;
	}

	@Override
	public String toString() {
		return "[maLop=" + maLop + ", tenLop=" + tenLop + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc="
				+ ngayKetThuc + "]";
	}
}
