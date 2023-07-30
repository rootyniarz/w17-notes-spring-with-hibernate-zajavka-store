package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.CustomerDatabaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class NamedQueriesService {
    private final CustomerDatabaseRepository customerRepository;

    @Transactional
    public void call() {
        List<CustomerEntity> allCustomers = customerRepository.findAllCustomers();
        System.out.println("#ALL CUSTOMERS: " + allCustomers);
        CustomerEntity customerByEmail1 = customerRepository
                .findCustomerByEmail("bstilwell1k@deliciousdays.com");
        System.out.println("#CUSTOMER BY EMAIL: " + customerByEmail1);
    }
}
