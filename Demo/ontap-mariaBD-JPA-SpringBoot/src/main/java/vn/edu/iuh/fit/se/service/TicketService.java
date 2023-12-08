package vn.edu.iuh.fit.se.service;

import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface TicketService {
    void insert(Ticket item);

    void update(Ticket item);

    void delete(UUID uuid);

    Optional<Ticket> getById(UUID uuid);

    List<Ticket> getAll();
}
