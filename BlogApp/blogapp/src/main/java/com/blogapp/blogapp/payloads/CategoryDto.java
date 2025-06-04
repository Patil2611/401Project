package com.blogapp.blogapp.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CategoryDto {
    private int id;
    
    @NotBlank
    @Size(min = 5, max = 15, message = "Please enter title between 5 - 15 Characters")
    private String title;

    private String description;

}
