package ecommerce2.v1.business.concretes;


import ecommerce2.v1.core.exception.NotFoundException;
import ecommerce2.v1.core.utilities.Message;
import ecommerce2.v1.dao.SupplierRepository;
import ecommerce2.v1.entities.Supplier;
import ecommerce2.v1.business.abstracts.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SupplierManager implements SupplierService {
    private final SupplierRepository supplierRepository;
    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(Supplier supplier) {
        getId(supplier.getId());
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier getId(long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new NotFoundException(Message.NOT_FOUND_MESSAGE));
    }

    @Override
    public Page<Supplier> cursor(int page, int pageSize) {
        return supplierRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        supplierRepository.delete(getId(id));
        return true;
    }
}
