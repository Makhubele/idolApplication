package com.ExcelWriter.ComputerUsageLogBook;

import com.sun.corba.se.spi.ior.ObjectId;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ComputerUsageLogBookApplication {
	private static final String PATH_TO_EXCEL = "C:/Desktop/Users.xlsx";
	public static void main(String[] args) {
		SpringApplication.run(ComputerUsageLogBookApplication.class, args);
		ComputerUsageLogBookApplication logBookApplication = new ComputerUsageLogBookApplication();
		//List<User> users = logBookApplication.getListOfUsers();
	}

	private void logbook(String pathToExcel, List<User> users){
		final String[] header = {"ID", "First Name", "Last Name", "Email", "Time"};
		Workbook workbook = null;
		try {
			//create workbook
			workbook = new XSSFWorkbook();

			//create sheet
			Sheet sheet = workbook.createSheet("Users");

			//ceate row header
			Row row = sheet.createRow(0);
			for(int i = 0; i < header.length; i++){
				row.createCell(i).setCellValue(header[i]);
			}

			int rowNum = 1;
			for (User user : users){
				row.createCell(0).setCellValue(user.getID());
				row.createCell(1).setCellValue(user.getFirstName());
				row.createCell(2).setCellValue(user.getLastName());
				row.createCell(3).setCellValue(user.getEmail());
				row.createCell(4).setCellValue(user.getDatetime());
			}
			//write sheet data
			FileOutputStream fileOutputStream = new FileOutputStream(pathToExcel);
			workbook.write(fileOutputStream);

		} catch (EncryptedDocumentException | FileNotFoundException e){
			   e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(workbook != null){
					workbook.close();
				}
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}


   private List<User> getListOfUsers() throws ParseException{
   	  //Create Array list of users
   	  List<User> users = new ArrayList<User>();

   	  //get calender date time
   	  Calendar time = Calendar.getInstance();
	  time.set(2020,6,23);

	  //get local date API
	   //LocalDate date = new LocalDate.of(2016, Month.JANUARY,24);

	  //set users
	  users.add(new User(1, "Shezy","Makhubele","makhubeleshezy@gmail.com",time.getTime()));
	  users.add(new User(2,"Basil","Maringa","basil@gmail.com" ,time.getTime()));

   	return users;
   }
}

//	@GetMapping(value = "/company/{companyId}")
//	public List<Project> getAllByCompany(@PathVariable("companyId") String companyId) {
//		return getRepository().getAll(new ObjectId(companyId));
//	}


//	@Query("{\"company.$id\": ?0 }")
//	List<Project> getAll(ObjectId companyId);


//601910509a660722b64e0453 shezy IT

//6019107a9a660722b64e0454 Maphaha IT
