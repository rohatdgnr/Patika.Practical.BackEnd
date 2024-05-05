package ecommerce2.v1.dto.request.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategorySaveRequest {
    @NotBlank(message = "Saved data cannot be empty.")
    @NotEmpty(message = "Saved data cannot be empty.")
    @NotNull(message = "Saved data cannot be empty.")
    private String name;
}
