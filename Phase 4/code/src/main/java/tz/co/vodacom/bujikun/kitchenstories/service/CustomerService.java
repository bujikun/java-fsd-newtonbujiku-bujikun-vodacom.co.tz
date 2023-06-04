package tz.co.vodacom.bujikun.kitchenstories.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tz.co.vodacom.bujikun.kitchenstories.entity.Customer;
import tz.co.vodacom.bujikun.kitchenstories.repository.CustomerRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomerService {
    //#{#entityName}
    private final CustomerRepository customerRepository;
    public void save(Customer customer){
        customer.setCreatedOn(LocalDateTime.now());
        customerRepository.save(customer);
    }
    public List<Customer> findAll(){
        return (List<Customer>) customerRepository.findAll();
    }
}
