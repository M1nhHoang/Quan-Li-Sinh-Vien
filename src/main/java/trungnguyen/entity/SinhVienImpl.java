package trungnguyen.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SinhVienImpl extends Lop implements SinhVien {
	private int MSV;
	private String hoTen;
	private Date ngaySinh;
	private String diaChi;
	private String soDt;
	private double diem1;
	private double diem2;
	private double diem3;
	
	public SinhVienImpl() {
		
	}
	
	public SinhVienImpl(int mSV, String hoTen, Date ngaySinh, String diaChi, String soDt, double diem1, double diem2,
			double diem3, int maLop, String tenLop, Date ngayBatDau, Date ngayKetThuc) {
		super(maLop, tenLop, ngayBatDau, ngayKetThuc);
		MSV = mSV;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.soDt = soDt;
		this.diem1 = diem1;
		this.diem2 = diem2;
		this.diem3 = diem3;
	}

	public int getMSV() {
		return MSV;
	}

	public void setMSV(int mSV) {
		MSV = mSV;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDt() {
		return soDt;
	}

	public void setSoDt(String soDt) {
		this.soDt = soDt;
	}

	public double getDiem1() {
		return diem1;
	}

	public void setDiem1(double diem1) {
		this.diem1 = diem1;
	}

	public double getDiem2() {
		return diem2;
	}

	public void setDiem2(double diem2) {
		this.diem2 = diem2;
	}

	public double getDiem3() {
		return diem3;
	}

	public void setDiem3(double diem3) {
		this.diem3 = diem3;
	}

	public double diemTongKet() {
		return Math.round((this.diem1 + this.diem2 + this.diem3) / 3 * 100) / 100;
	}

	@Override
	public String toString() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formatString = "%-5s | %-25s | %-10s | %-10s | %-25s | %-11s | %-6s | %-6s | %-6s | %-6s%n";
	    String row = String.format(formatString, MSV, hoTen, super.getTenLop(), dateFormat.format(ngaySinh), diaChi, soDt, diem1, diem2, diem3, diemTongKet());
	    
	    return row;
	}

}
