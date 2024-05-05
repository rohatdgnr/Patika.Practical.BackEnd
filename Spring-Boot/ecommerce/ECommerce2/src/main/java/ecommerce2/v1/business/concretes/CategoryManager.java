package ecommerce2.v1.business.concretes;

import ecommerce2.v1.business.abstracts.CategoryService;
import ecommerce2.v1.core.utilities.Message;
import ecommerce2.v1.dao.CategoryRepository;
import ecommerce2.v1.entities.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getId(long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new art.dborg.ecommerce2.v1.core.exception.NotFoundException(Message.NOT_FOUND_MESSAGE));
    }

    @Override
    public Category update(Category category) {
        getId(category.getId());
        return categoryRepository.save(category);
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        return categoryRepository.findAll(PageRequest.of(page,pageSize));
    }

    @Override
    public boolean delete(long id) {
        categoryRepository.delete(getId(id));
        return true;
    }
}
