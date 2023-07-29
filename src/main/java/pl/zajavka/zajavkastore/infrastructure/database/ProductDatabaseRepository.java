package pl.zajavka.zajavkastore.infrastructure.database;

import org.springframework.stereotype.Repository;
import pl.zajavka.zajavkastore.business.ProductDAO;
import pl.zajavka.zajavkastore.infrastructure.database.entity.ProductEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ProductDatabaseRepository implements ProductDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public ProductEntity getProduct(final Integer productId) {
        return entityManager.find(ProductEntity.class, productId);
    }

    @Override
    public void saveProduct(final ProductEntity productEntity) {
        entityManager.persist(productEntity);
    }

    @Override
    public void deleteProduct(final Integer productId) {
        entityManager.remove(entityManager.find(ProductEntity.class, productId));
    }
}
