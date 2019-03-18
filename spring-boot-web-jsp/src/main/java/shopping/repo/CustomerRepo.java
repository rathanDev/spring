package shopping.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import shopping.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, String> {

    Customer getCustomerByUsername(@Param("username") String username);

}
