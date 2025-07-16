package org.api.springbootrestapimongodb.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.api.springbootrestapimongodb.dto.AuthorDTO;
import org.api.springbootrestapimongodb.dto.CommentDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private AuthorDTO author;

    @Getter
    private List<CommentDTO> comments = new ArrayList<>();

    public Post() {}

    @Builder
    public Post(String id, LocalDate date, String title, String body, AuthorDTO author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
