package ecommerce2.v1.business.abstracts;

import ecommerce2.v1.entities.Supplier;
import org.springframework.data.domain.Page;

public interface SupplierService {
    Supplier save(Supplier supplier);
    Supplier update(Supplier supplier);
    Supplier getId(long id);
    Page<Supplier> cursor(int page, int pageSize);
    boolean delete(long id);
}
