package vn.edu.iuh.fit.se;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.se.entity.Customer;
import vn.edu.iuh.fit.se.entity.Ticket;
import vn.edu.iuh.fit.se.service.CustomerService;
import vn.edu.iuh.fit.se.service.TicketService;
import vn.edu.iuh.fit.se.service.impl.CustomerServiceImpl;
import vn.edu.iuh.fit.se.service.impl.TicketServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class OntapMariaBdJpaSpringBootApplication {

    @Autowired
    private CustomerServiceImpl customerService;
    @Autowired
    private TicketServiceImpl ticketService;

    public static void main(String[] args) {
        SpringApplication.run(OntapMariaBdJpaSpringBootApplication.class, args);
    }

    @Bean
    public CommandLineRunner sampleRecord() {
        return args -> {
            System.out.println("---- Start -----");

            Customer cus1 = new Customer();
            cus1.setAddress("12 phan co tich 2");
            cus1.setAge(21);
            cus1.setName("Nguyen Van 1");
//            customerService.insert(cus1);
//            System.out.println(cus1);

//            Optional<Customer> optionalCus = customerService.getById(UUID.fromString("36548567-0c55-43c1-b71a-23bf3a6c8344"));
//            if(!optionalCus.isPresent()) {
//                System.out.println("Khongo tim thay!");
//                return ;
//            }

//            Customer customer = optionalCus.get();
//			Ticket ticket = new Ticket();
//			ticket.setCustomer(customer);
//            ticket.setPrice(200);
//            ticket.settGianChieu(LocalDate.now());
//            ticket.setTitle("Avatar 2");
//            ticket.setThoiLuong(2.5f);

//            ticketService.insert(ticket);



            ///
            customerService.getAll().forEach(System.out::println);
            ticketService.getAll().forEach(System.out::println);
            System.out.println("---- END -----");
        };
    }

}
