package edu.miu.modling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDto {
    private long id;
    private String title;
    private String content;
    private String author;
}
