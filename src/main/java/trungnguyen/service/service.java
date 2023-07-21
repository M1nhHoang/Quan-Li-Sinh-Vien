package trungnguyen.service;

public interface service {
	// Lấy số lượng học sinh hiện có.
	int getNumberStudents();
	
	// Thêm sinh Viên.
	void addStudents();
	
	// In danh sách sinh viên.
	void printStudents();
	
	// In danh sách sinh viên của từng lớp.
	void printsStudentsClass();
	
	// Sắp xếp điểm theo thứ tự tăng dần.
	void ascendingPointSort();
	
	// Sắp xếp điểm theo thứ tự giảm dần.
	void decreasePointSort();
	
	// Tìm kiếm theo tên.
	void findByName();
	
	// Tìm kiếm theo mã sv.
	void findByStdCode();
	
	// Xóa Sinh viên theo mã sv.
	void removeByStdCode();
}
