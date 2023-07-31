package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.CustomerDatabaseRepository;

@Service
@AllArgsConstructor
public class SortingService {
    private final CustomerDatabaseRepository customerRepository;

    public void sortingExample() {
        Sort sort = Sort.by("name").ascending()
                .and(Sort.by("dateOfBirth").ascending());
        customerRepository.findAll(sort)
                .forEach(customer -> System.out.println("###Customer: " + customer));
    }
}

