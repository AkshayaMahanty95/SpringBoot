package com.ticket.booking.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ticket.booking.domain.Ticket;
import com.ticket.booking.service.TicketService;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
	
	@Autowired
	private TicketService service;
	
	@GetMapping("/getAllTickets")
	public Iterable<Ticket> getAllTickets(){
		return service.getAllTickets();
	}
	@PostMapping("/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return service.createTicket(ticket);
		
	}
	@GetMapping("/ticket/{ticketId}")
	public Optional<Ticket> getTicket(@PathVariable("ticketId")Integer ticketId){
		return service.getTicket(ticketId);
	}
	@DeleteMapping("/ticket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId")Integer ticketId){
		service.deleteTicket(ticketId);
	}
	@PutMapping("/ticket/{ticketId}/{newEmail}")
	public Ticket updateTicket(@PathVariable("ticketId")Integer ticketId, @PathVariable("newEmail") String newEmail){
		return service.updateTicket(ticketId,newEmail);
	}
}
