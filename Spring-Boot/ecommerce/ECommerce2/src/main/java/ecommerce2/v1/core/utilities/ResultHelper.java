package ecommerce2.v1.core.utilities;

import ecommerce2.v1.core.result.Result;
import ecommerce2.v1.core.result.ResultData;
import ecommerce2.v1.dto.response.CursorResponse;
import ecommerce2.v1.dto.response.category.CategoryResponse;
import org.springframework.data.domain.Page;

public class ResultHelper {
    public static <T> ResultData<T> CREATED(T data){
        return new ResultData<>(true,Message.CREATED_MESSAGES,"201",data);
    }
    public static <T> ResultData<T> ERROR(T data){
        return new ResultData<>(false,Message.NOT_NULL_MESSAGE,"400",data);
    }
    public static <T> ResultData<T> OK(T data){
        return new ResultData<>(true,Message.OK_MESSAGE,"200",data);
    }
    public static  Result NOT_FOUND(){
        return new Result(false,Message.NOT_FOUND_MESSAGE,"400");
    }
    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData){
        CursorResponse<T> cursor = new CursorResponse<>();

        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());

        return ResultHelper.OK(cursor);
    }
}
