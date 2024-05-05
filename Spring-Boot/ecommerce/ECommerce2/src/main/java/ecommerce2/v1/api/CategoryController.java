package ecommerce2.v1.api;


import ecommerce2.v1.business.abstracts.CategoryService;
import ecommerce2.v1.core.config.modelMapper.ModelMapperService;
import ecommerce2.v1.core.result.Result;
import ecommerce2.v1.core.result.ResultData;
import ecommerce2.v1.core.utilities.ResultHelper;
import ecommerce2.v1.dto.request.category.CategorySaveRequest;
import ecommerce2.v1.dto.request.category.CategoryUpdateRequest;
import ecommerce2.v1.dto.response.CursorResponse;
import ecommerce2.v1.dto.response.category.CategoryResponse;
import ecommerce2.v1.entities.Category;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final ModelMapperService modelMapperService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> getId(@PathVariable("id") long id) {
        return ResultHelper.OK(modelMapperService.forResponse().map(categoryService.getId(id), CategoryResponse.class));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<CategoryResponse> save(@Valid @RequestBody CategorySaveRequest categorySaveRequest) {
        CategoryResponse categoryResponse = modelMapperService.forResponse().map(categoryService.save(modelMapperService.forRequest().map(categorySaveRequest, Category.class)), CategoryResponse.class);
        return ResultHelper.CREATED(categoryResponse);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CategoryResponse> update(@Valid @RequestBody CategoryUpdateRequest categoryUpdateRequest) {
        CategoryResponse categoryResponse = modelMapperService.forResponse().map(categoryService.update(modelMapperService.forRequest().map(categoryUpdateRequest, Category.class)), CategoryResponse.class);
        return ResultHelper.OK(categoryResponse);
    }

    @GetMapping
    public ResultData<CursorResponse<CategoryResponse>> cursor(@RequestParam(name = "page", required = false, defaultValue = "0") int page, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {

        Page<Category> categories = categoryService.cursor(page,pageSize);
        Page<CategoryResponse> categoryResponses = categories.map(category -> modelMapperService.forResponse().map(category,CategoryResponse.class));

        return ResultHelper.cursor(categoryResponses);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Result delete(@PathVariable("id") long id){
        return ResultHelper.OK(categoryService.delete(id));
    }
}
