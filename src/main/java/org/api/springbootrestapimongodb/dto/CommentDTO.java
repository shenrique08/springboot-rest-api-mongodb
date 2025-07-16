package org.api.springbootrestapimongodb.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Setter
@Builder
public class CommentDTO implements Serializable {

    private String text;
    private LocalDate date;
    private AuthorDTO author;

    public CommentDTO() {}

    public CommentDTO(String text, LocalDate date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }
}
