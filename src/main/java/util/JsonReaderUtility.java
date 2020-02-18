package util;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.Employee;

public class JsonReaderUtility {
	public static void readJsonFromFile() throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		InputStream is = Employee.class.getResourceAsStream("/employees.json");
		Employee employee = mapper.readValue(is, Employee.class);
		System.out.println("FirstName: " + employee.getFirstName());
	}

}
