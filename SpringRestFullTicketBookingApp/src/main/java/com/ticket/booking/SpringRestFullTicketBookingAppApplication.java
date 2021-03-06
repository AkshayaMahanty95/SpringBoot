package com.ticket.booking;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ticket.booking.domain.Ticket;
import com.ticket.booking.service.TicketService;

@SpringBootApplication
public class SpringRestFullTicketBookingAppApplication implements CommandLineRunner {
	 @Autowired
	    private TicketService service;

	public static void main(String[] args) {
		SpringApplication.run(SpringRestFullTicketBookingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		 Ticket ticket = new Ticket();
         ticket.setPassengerName("CHERRY");
         ticket.setEmail("cherrysonu@gmail.com");
         ticket.setSourceStation("Hyderabad");
         ticket.setDestinationStation("bambay");
         ticket.setBookingDate(new Date());
         service.createTicket(ticket);
		
	}

}
