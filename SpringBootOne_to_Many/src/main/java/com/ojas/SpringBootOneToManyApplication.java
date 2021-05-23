package com.ojas;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ojas.dao.LaptopDao;
import com.ojas.dao.StudentDao;
import com.ojas.entity.Laptop;
import com.ojas.entity.Student;



@SpringBootApplication

public class SpringBootOneToManyApplication implements CommandLineRunner {
	
	@Autowired
	private StudentDao sdao;
	
	@Autowired
	private LaptopDao ldao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootOneToManyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		saveData();
		
	}
	
	@Transactional
	private void saveData() {
		Laptop laptop = new Laptop(2,"Dell");
		ldao.save(laptop);
		
		Student s = new Student(11,"aks",22,laptop);
		sdao.save(s);
		System.out.println("inserted");
		
	}

}
