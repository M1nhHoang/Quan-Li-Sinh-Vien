package trungnguyen.dataContext;

import java.util.Hashtable;

import trungnguyen.entity.SinhVienImpl;

public interface ReadWriteTxtFile {
	// Xuất File txt
	void WriteFile(String filePath, String content);
	
	// Đọc File txt
	Hashtable<Integer, SinhVienImpl> ReadFile(String filePath);
}
