package com.test;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.test.dao.LaptopDao;
import com.test.dao.StudentDao;
import com.test.domain.Laptop;
import com.test.domain.Student;

@SpringBootApplication
public class SpringBootOneToOneApplication implements CommandLineRunner {

	@Autowired
	private LaptopDao laptopdao;
	
	@Autowired
	private StudentDao studentdao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootOneToOneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		saveData();
	
	}	
		@Transactional
		private void saveData() {
			Laptop laptop = new Laptop(2,"Dell");
			laptopdao.save(laptop);
			
			Student s = new Student(11,"aks",22,laptop);
			studentdao.save(s);
			System.out.println("inserted");
			
		}
		
		@Transactional
		private void showData() {
			List<Laptop> laptops = laptopdao.findAll();
			List<Student> students = studentdao.findAll();
			
			students.forEach(System.out::println);
			laptops.forEach(System.out::println);
		}
	}
