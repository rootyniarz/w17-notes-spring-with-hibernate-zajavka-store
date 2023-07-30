package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import pl.zajavka.zajavkastore.infrastructure.database.entity.CustomerEntity;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.CustomerDatabaseRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class QueryByExampleService {

    private final CustomerDatabaseRepository customerRepository;

    public void queryByExample() {
        CustomerEntity customerExample = CustomerEntity.builder().name("Florian").build();
        Example<CustomerEntity> example = Example.of(customerExample);
        List<CustomerEntity> result = customerRepository.findAll(example);
        System.out.println("#Found: " + result.size());
    }

    public void queryByExampleExampleMatcher() {
        ExampleMatcher caseInsensitiveExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase();
        CustomerEntity customerExample = CustomerEntity.builder().name("Florian").build();
        Example<CustomerEntity> example = Example.of(customerExample, caseInsensitiveExampleMatcher);
        List<CustomerEntity> result = customerRepository.findAll(example);
        System.out.println("#Found: " + result.size());
    }

    public void queryByExampleExampleMatcherCustom() {
        ExampleMatcher customExampleMatcher = ExampleMatcher.matchingAll()
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase())
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith().ignoreCase());
        CustomerEntity customerExample = CustomerEntity.builder()
                .email("com")
                .name("G")
                .build();
        Example<CustomerEntity> example = Example.of(customerExample, customExampleMatcher);
        List<CustomerEntity> result = customerRepository.findAll(example);
        System.out.println("#Found: " + result.size());
    }
}

