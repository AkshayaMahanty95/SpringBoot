package com.ticket.booking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ticket.booking.dao.TicketBookingDao;
import com.ticket.booking.domain.Ticket;

@Service
public class TicketService {
	
	@Autowired
	private TicketBookingDao ticketBookingDao;
	
	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}
	public Iterable<Ticket> getAllTickets() {
		return ticketBookingDao.findAll();
	}
	public Optional<Ticket> getTicket(Integer ticketId) {
		
		return ticketBookingDao.findById(ticketId);
	}
	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}
	public Ticket updateTicket(Integer ticketId, String newEmail) {
		Ticket ticket = ticketBookingDao.findById(ticketId).orElse(new Ticket());
		ticket.setEmail(newEmail);
		return ticketBookingDao.save(ticket);
	}
}
