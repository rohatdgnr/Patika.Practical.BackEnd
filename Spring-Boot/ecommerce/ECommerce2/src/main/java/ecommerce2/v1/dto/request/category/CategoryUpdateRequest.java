package ecommerce2.v1.dto.request.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryUpdateRequest {
    @Positive(message = "ID not smaller than 1")
    private long id;
    @NotBlank(message = "Updated data cannot be empty.")
    @NotEmpty(message = "Updated data cannot be empty.")
    @NotNull(message = "Updated data cannot be empty.")
    private String name;
}
