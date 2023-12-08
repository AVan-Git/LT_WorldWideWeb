package vn.edu.iuh.fit.se.service.impl;

import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.se.entity.Ticket;
import vn.edu.iuh.fit.se.repositories.TicketRepository;
import vn.edu.iuh.fit.se.service.TicketService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository repository;

    @Override
    public void insert(Ticket item) {
        repository.save(item);
    }

    @Override
    public void update(Ticket item) {

        repository.save(item);
    }

    @Override
    public void delete(UUID uuid) {
        repository.deleteById(uuid);

    }

    @Override
    public Optional<Ticket> getById(UUID uuid) {
        Optional<Ticket> optional = null;
        optional = repository.findById(uuid);
        return optional.isPresent() ? Optional.of(optional.get()) : Optional.empty();
    }

    @Override
    public List<Ticket> getAll() {
        List<Ticket> lst = new ArrayList<>();
        lst = repository.findAll();
        return lst;
    }
}
