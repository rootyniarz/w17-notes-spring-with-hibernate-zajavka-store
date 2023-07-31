package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.CustomerDatabaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class EntityGraphService {
    private final CustomerDatabaseRepository customerDatabaseRepository;

    public void call() {
//        List<CustomerEntity> customers = customerDatabaseRepository.findAllByEmailContaining(".com");
//        customers.forEach(custommer -> System.out.println("###Entity :" + custommer));

        CustomerEntity customer = customerDatabaseRepository.findByEmail("agatsby2p@indiatimes.com");
//        CustomerEntity customer = customerDatabaseRepository.findByCustomerId(98).orElseThrow();

        System.out.println(customer.getPurchaseEntities());

    }
}
