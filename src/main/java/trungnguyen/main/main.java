package trungnguyen.main;

import java.util.Scanner;

import trungnguyen.service.serviceImpl;

public class main {
	public static void main(String[] args) {
		// Instance service
		serviceImpl service = new serviceImpl();
		
		Scanner input = new Scanner(System.in);
		int option = -1;
		
		while (option != 0) {
			System.out.println("===============================================");
			System.out.println("||-------------QUAN LI SINH VIEN-------------||");
			System.out.println("|| 1. THEM SINH VIEN_________________________||");
			System.out.println("|| 2. XUAT DANH SACH SINH VIEN_______________||");
			System.out.println("|| 3. XUAT DANH SACH THEO LOP________________||");
			System.out.println("|| 4. SAP XEP THEO DIEM TONG KET TANG DAN____||"); 
			System.out.println("|| 5. SAP XAP THEO DIEM TONG KET GIAM DAN____||");
			System.out.println("|| 6. TIM KIEM SINH VIEN THEO TEN____________||");
			System.out.println("|| 7. TIM KIEM SINH VIEN THEO MSSV___________||");
			System.out.println("|| 8. XOA THONG TIN SINH VIEN THEO MSSV______||");
			System.out.println("|| 0. THOAT__________________________________||");
			System.out.println("===============================================");
			System.out.println("Hien tai co " + service.getNumberStudents() + " sinh vien.");
			System.out.println("Lua chon tac vu cua ban la (0-8): ");
			try {
				option = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println("------- LUA CHON PHAI LA SO -------");
			}
			
			// Chọn
			switch (option) {
				case 1:
					service.addStudents();
					break;
				case 2:
					service.printStudents();
					break;
				case 3:
					service.printsStudentsClass();
					break;
				case 4:
					service.ascendingPointSort();
					break;
				case 5:
					service.decreasePointSort();
					break;
				case 6:
					service.findByName();
					break;
				case 7:
					service.findByStdCode();
					break;
				case 8:
					service.removeByStdCode();
					break;
				default:
					break;
			}
		}
		
		System.out.println("\n\nDA THOAT CHUONG TRINH\n\n");
    }
}
