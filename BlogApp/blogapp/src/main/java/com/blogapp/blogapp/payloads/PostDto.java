package com.blogapp.blogapp.payloads;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PostDto {
    private String title;
    private String content;
    private String author;
    private Date createdDate;
    private String image = "default.png";
    private UserDto user;
    private CategoryDto category;

}
