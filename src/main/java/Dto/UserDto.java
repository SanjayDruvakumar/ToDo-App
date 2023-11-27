package Dto;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



import lombok.Data;

@Entity
@Data
public class UserDto {
	@Id
	String name;
	String email;
	String pass;
	long pNumber;
	String gender;
	LocalDate dob;
	int age;
}
