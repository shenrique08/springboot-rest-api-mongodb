package org.api.springbootrestapimongodb.dto;

import lombok.Getter;
import lombok.Setter;
import org.api.springbootrestapimongodb.domain.User;

import java.io.Serializable;


@Getter
@Setter
public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO() {}

    public AuthorDTO(User user) {
        id = user.getId();
        name = user.getName();
    }
}
