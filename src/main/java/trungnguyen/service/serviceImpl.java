package trungnguyen.service;

import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import trungnguyen.dataContext.ReadWriteTxtFileImpl;
import trungnguyen.entity.Lop;
import trungnguyen.entity.SinhVienImpl;

public class serviceImpl implements service {
	private ReadWriteTxtFileImpl data;
	private SimpleDateFormat dateFormat;
	private Scanner input;
	private final String filePath = "./data.txt";
	
	public serviceImpl() {
		dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		input = new Scanner(System.in);
		data = new ReadWriteTxtFileImpl();
	}

	@Override
	public int getNumberStudents() {
		return data.ReadFile(this.filePath).size();
	}

	@Override
	public void printStudents() {
		String formatString = "%-5s | %-25s | %-10s | %-10s | %-25s | %-11s | %-6s | %-6s | %-6s | %-6s%n";
		String formatContentString = "%-58s %-77s %-2s%n";
	    String header = String.format(formatString, "MSV", "HO TEN", "LOP", "NGAY SINH", "DIA CHI", "SO DT", "DIEM 1", "DIEM 2", "DIEM 3", "TONG KET");
	    String content = String.format(formatContentString, "||", "DANH SACH SINH VIEN", "||");
	    
	    // In content + header
	    System.out.println("===========================================================================================================================================");
	    System.out.print(content);
	    System.out.println("===========================================================================================================================================");
	    System.out.println(header);
	    
	    // In danh sách sinh viên
	    for (SinhVienImpl sinhVien : data.ReadFile(filePath).values()) {
	    	System.out.println(sinhVien.toString());
		}
	}
	
	public void printStudents(List<SinhVienImpl> dsSinhVien) {
		String formatString = "%-5s | %-25s | %-10s | %-10s | %-25s | %-11s | %-6s | %-6s | %-6s | %-6s%n";
		String formatContentString = "%-58s %-77s %-2s%n";
	    String header = String.format(formatString, "MSV", "HO TEN", "LOP", "NGAY SINH", "DIA CHI", "SO DT", "DIEM 1", "DIEM 2", "DIEM 3", "TONG KET");
	    String content = String.format(formatContentString, "||", "DANH SACH SINH VIEN", "||");
	    
	    // In content + header
	    System.out.println("===========================================================================================================================================");
	    System.out.print(content);
	    System.out.println("===========================================================================================================================================");
	    System.out.println(header);
	    
	    // In danh sách sinh viên
	    for (SinhVienImpl sinhVien : dsSinhVien) {
	    	System.out.println(sinhVien.toString());
		}
	}
	
	@Override
	public void printsStudentsClass() {
		// tạo 1 hash table chứ danh sách các lớp học.
		Hashtable<Lop, List<SinhVienImpl>> classes = new Hashtable<Lop, List<SinhVienImpl>>();
		
		// Sắp xếp sinh viên theo từng lớp.
		Lop lop = null;
		for (SinhVienImpl sv : data.ReadFile(filePath).values()) {
			// tạo object Lop
			lop = new Lop(sv.getMaLop(), sv.getTenLop(), sv.getNgayBatDau(), sv.getNgayKetThuc());
			
			// Kiểm tra xem đã tồn tại trong hashtable chưa
			// Nếu rồi thì thêm vào danh sách sinh viên
			if (classes.containsKey(lop)) {
				classes.get(lop).add(sv);
			}
			// Nếu chưa thì tạo cặp key và value mới
			else {
				List<SinhVienImpl> newList = new ArrayList<SinhVienImpl>();
				newList.add(sv);
				classes.put(lop, newList);
			}
		}
		
		// Định dạng chuỗi trước khi in,
		String formatString = "%-5s | %-25s | %-10s | %-10s | %-25s | %-11s | %-6s | %-6s | %-6s | %-6s%n";
		String formatContentString = "%-58s %-77s %-2s%n";
	    String header = String.format(formatString, "MSV", "HO TEN", "LOP", "NGAY SINH", "DIA CHI", "SO DT", "DIEM 1", "DIEM 2", "DIEM 3", "TONG KET");
	    String content = String.format(formatContentString, "||", "DANH SACH SINH VIEN", "||");
	    
	    // In content + header
	    System.out.println("===========================================================================================================================================");
	    System.out.print(content);
	    System.out.println("===========================================================================================================================================");
		
		// In danh sách ra theo từng lớp.
		Iterator<Lop> iterator = classes.keySet().iterator();
        while (iterator.hasNext()) {
        	// Lấy giá trị của key và value
            Lop key = iterator.next();
            List<SinhVienImpl> value = classes.get(key);
            
            // In ra Lớp
            String classContent = String.format(formatContentString, "||", key.getTenLop(), "||");
            System.out.println("===========================================================================================================================================");
    	    System.out.print(classContent);
    	    System.out.println("===========================================================================================================================================");
    	    System.out.println(header);
            
    	    // In danh sách sinh viên của mỗi lớp.
    	    for (SinhVienImpl sinhVien : value) {
    	    	System.out.println(sinhVien.toString());
    		}
        }
	}

	@Override
	public void ascendingPointSort() {
		List<SinhVienImpl> dsSinhVien = new ArrayList<>(data.ReadFile(filePath).values());

		// selection sort
		SinhVienImpl svTemp = null;
		for (int i = 0; i < dsSinhVien.size(); i++) {
			for (int j = i+1; j < dsSinhVien.size(); j++) {
				if (dsSinhVien.get(j).diemTongKet() < dsSinhVien.get(i).diemTongKet()) {
					// swap
					svTemp = dsSinhVien.get(j);
					dsSinhVien.set(j, dsSinhVien.get(i));
					dsSinhVien.set(i, svTemp);
				}
			}
		}
		
		// In danh sách
		this.printStudents(dsSinhVien);
	}

	@Override
	public void decreasePointSort() {
		List<SinhVienImpl> dsSinhVien = new ArrayList<>(data.ReadFile(filePath).values());

		// selection sort
		SinhVienImpl svTemp = null;
		for (int i = 0; i < dsSinhVien.size(); i++) {
			for (int j = i+1; j < dsSinhVien.size(); j++) {
				if (dsSinhVien.get(j).diemTongKet() > dsSinhVien.get(i).diemTongKet()) {
					svTemp = dsSinhVien.get(j);
					dsSinhVien.set(j, dsSinhVien.get(i));
					dsSinhVien.set(i, svTemp);
				}
			}
		}
		
		// In danh sách
		this.printStudents(dsSinhVien);
	}

	@Override
	public void findByName() {
		System.out.println("NHAP TEN SINH VIEN CAN TIM: ");
		String findContent = input.nextLine();
		
		List<SinhVienImpl> dsSinhVien = new ArrayList<>(data.ReadFile(filePath).values());

        // Tìm kiếm các tên gần giống
        List<SinhVienImpl> resultSreach = new ArrayList<SinhVienImpl>();
        for (SinhVienImpl sv : dsSinhVien) {
        	
        	String name = sv.getHoTen().toLowerCase();
        	
            if (name.contains(findContent.toLowerCase())) {
            	resultSreach.add(sv);
            }
        }
        
        // In danh sách
        this.printStudents(resultSreach);
	}

	@Override
	public void findByStdCode() {
		System.out.println("NHAP MSSV CAN TIM: ");
		
		// Tìm theo Key của hashset
		List<SinhVienImpl> dsSinhVien = null;
		try {
			SinhVienImpl sv = data.ReadFile(filePath).get(Integer.parseInt(input.nextLine()));
			
			dsSinhVien = new ArrayList<SinhVienImpl>();
			dsSinhVien.add(sv);
			
		} catch (Exception e) {
			System.out.println("----MSSV phai la so!----");
		}
		
		// In danh sách
        this.printStudents(dsSinhVien);
	}

	@Override
	public void removeByStdCode() {
		System.out.println("NHAP MSSV CAN XOA: ");
		Hashtable<Integer, SinhVienImpl> newData = data.ReadFile(filePath);
		try {
			newData.remove(Integer.parseInt(input.nextLine()));
		} catch (Exception e) {
			System.out.println("----MSSV phai la so!----");
		}
		
		// Tạo dữ liệu
		String content = "";
		
		for (SinhVienImpl sv : newData.values()) {
			content += sv.getMSV() + "," + sv.getHoTen() + "," + dateFormat.format(sv.getNgaySinh())  + "," +  sv.getDiaChi()
			 + "," +  sv.getSoDt() + "," + sv.getDiem1() + "," + sv.getDiem2() + "," + sv.getDiem3()
			 + "," + sv.getMaLop() + "," + sv.getTenLop() + "," + dateFormat.format(sv.getNgayBatDau()) + "," + dateFormat.format(sv.getNgayKetThuc()) + "///";
		}
		
		// Lưu dữ liệu
		data.WriteFile(filePath, content);
		
		// In dữ liêu
		this.printStudents();
	}

	@Override
	public void addStudents() {
		String content = "";
		
		// Tạo dữ liệu
		for (SinhVienImpl sv : data.ReadFile(filePath).values()) {
			content += sv.getMSV() + "," + sv.getHoTen() + "," + dateFormat.format(sv.getNgaySinh())  + "," +  sv.getDiaChi()
			 + "," +  sv.getSoDt() + "," + sv.getDiem1() + "," + sv.getDiem2() + "," + sv.getDiem3()
			 + "," + sv.getMaLop() + "," + sv.getTenLop() + "," + dateFormat.format(sv.getNgayBatDau()) + "," + dateFormat.format(sv.getNgayKetThuc()) + "///";
		}
		
		// Thêm dữ liệu
		System.out.println("MA SINH VIEN: " + (getNumberStudents()+1));
		content += (getNumberStudents()+1) + ",";
		System.out.println("NHAP TEN SINH VIEN: ");
		content += input.nextLine() + ",";
		System.out.println("NHAP NGAY SINH (NGAY/THANG/NAM): ");
		content += input.nextLine() + ",";
		System.out.println("NHAP DIA CHI: ");
		content += input.nextLine() + ",";
		System.out.println("NHAP SO DIEN THOAI: ");
		content += input.nextLine() + ",";
		System.out.println("NHAP DIEM 1: ");
		content += input.nextLine() + ",";
		System.out.println("NHAP DIEM 2: ");
		content += input.nextLine() + ",";
		System.out.println("NHAP DIEM 3: ");
		content += input.nextLine() + ",";
		System.out.println("NHAP MA LOP: ");
		content += input.nextLine() + ",";
		System.out.println("NHAP TEN LOP: ");
		content += input.nextLine() + ",";
		System.out.println("NHAP NGAY BAT DAU (NGAY/THANG/NAM): ");
		content += input.nextLine() + ",";
		System.out.println("NHAP KET THUC (NGAY/THANG/NAM): ");
		content += input.nextLine();
		
		// Lưu dữ liệu
		data.WriteFile(filePath, content);
	}

}
