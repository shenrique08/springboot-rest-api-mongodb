package org.api.springbootrestapimongodb.dto;

import lombok.Getter;
import lombok.Setter;
import org.api.springbootrestapimongodb.domain.User;

import java.io.Serializable;


@Getter
@Setter
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO() {}

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }
}
