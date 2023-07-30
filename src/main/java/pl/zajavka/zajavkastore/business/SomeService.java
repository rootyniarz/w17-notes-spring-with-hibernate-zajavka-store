package pl.zajavka.zajavkastore.business;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.zajavka.zajavkastore.infrastructure.database.entity.Stars;
import pl.zajavka.zajavkastore.infrastructure.database.jparepositories.*;

import java.util.Set;

@Service
@AllArgsConstructor
public class SomeService {

    private final CustomerDatabaseRepository customerDatabaseRepository;
    private final OpinionDatabaseRepository opinionDatabaseRepository;
    private final ProducerDatabaseRepository producerDatabaseRepository;
    private final ProductDatabaseRepository productDatabaseRepository;
    private final PurchaseDatabaseRepository purchaseDatabaseRepository;

    @Transactional
    public void call() {
//        System.out.println("#Customer: " + customerDatabaseRepository.findById(52));
//        System.out.println("#Opinion: " + opinionDatabaseRepository.findById(13));
//        System.out.println("#Producer: " + producerDatabaseRepository.findById(2));
//        System.out.println("#Product: " + productDatabaseRepository.findById(22));
//        System.out.println("#Purchase: " + purchaseDatabaseRepository.findById(117));
        System.out.println(opinionDatabaseRepository.countWrongOpinions());
        opinionDatabaseRepository.updateWrongOpinions(Stars.FOUR, Set.of(Stars.ONE, Stars.TWO, Stars.THREE));
        System.out.println(opinionDatabaseRepository.countWrongOpinions());
        opinionDatabaseRepository.deleteOpinionsContaining("ppgo");
        System.out.println(opinionDatabaseRepository.countWrongOpinions());

        System.out.println("liczba opinii w ogóle: "+opinionDatabaseRepository.countOpinions());

        System.out.println("Liczba najwiekszych gwiazdek: "+opinionDatabaseRepository.countMaxStars());
    }
}
