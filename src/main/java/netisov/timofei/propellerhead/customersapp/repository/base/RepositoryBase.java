package netisov.timofei.propellerhead.customersapp.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Base repository interface
 */
@NoRepositoryBean
public interface RepositoryBase<T, ID extends Serializable> extends JpaRepository<T, ID>, QuerydslPredicateExecutor<T> {
}
