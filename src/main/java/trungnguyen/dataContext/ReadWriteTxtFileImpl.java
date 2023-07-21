package trungnguyen.dataContext;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import trungnguyen.entity.SinhVienImpl;

public class ReadWriteTxtFileImpl implements ReadWriteTxtFile{
	public ReadWriteTxtFileImpl() {
		// TODO Auto-generated constructor stub
	}

	public void WriteFile(String filePath, String content) {
		// Lưu dữ liệu vào txt file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			// Lưu từng dòng dữ liệu vào file text
			for (String line : content.split("///")) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

	public Hashtable<Integer, SinhVienImpl> ReadFile(String filePath) {
		// Tạo 1 hashtable lưu trữ danh sách sinh viên đọc được
		Hashtable<Integer, SinhVienImpl> data = new Hashtable<Integer, SinhVienImpl>();
		
		// Định dạng dữ liệu ngày tháng
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            String[] content;
            SinhVienImpl sinhVien = null;
            
            // Đọc dữ liệu của từng dòng và lưu vào hashtable
            while ((line = reader.readLine()) != null) {
            	content = line.split(",");
                sinhVien = new SinhVienImpl(Integer.parseInt(content[0]), content[1], dateFormat.parse(content[2]), content[3], content[4], Double.parseDouble(content[5]), Double.parseDouble(content[6]), Double.parseDouble(content[7]), Integer.parseInt(content[8]), content[9], dateFormat.parse(content[10]), dateFormat.parse(content[11]));
                
                // Lưu Dữ liệu
                data.put(Integer.parseInt(content[0]), sinhVien);
            }
        } catch (IOException | NumberFormatException | ParseException e) {
            e.printStackTrace();
        }
        return data;
	}
	
}
