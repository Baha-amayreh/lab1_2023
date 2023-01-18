package edu.miu.modling.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostV2 {
    private long id;
    private String title;
    private String content;
    private String author;
}
