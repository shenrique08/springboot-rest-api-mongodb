package org.api.springbootrestapimongodb.config;

import org.api.springbootrestapimongodb.domain.Post;
import org.api.springbootrestapimongodb.domain.User;
import org.api.springbootrestapimongodb.dto.AuthorDTO;
import org.api.springbootrestapimongodb.repository.PostRepository;
import org.api.springbootrestapimongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        userRepository.deleteAll();
        postRepository.deleteAll();


        User ana = User.builder().name("Ana Clara Souza").email("ana.souza@example.com").build();
        User lucas = User.builder().name("Lucas Oliveira Costa").email("lucas.costa@example.com").build();
        User juliana = User.builder().name("Juliana Santos Pereira").email("juliana.pereira@example.com").build();
        User marcos = User.builder().name("Marcos Lima Ferreira").email("marcos.ferreira@example.com").build();

        userRepository.saveAll(Arrays.asList(ana, lucas, juliana, marcos));

        Post post1 = Post.builder()
                .date(LocalDate.parse("30/04/2025", formatter))
                .author(new AuthorDTO(ana))
                .title("Travelling")
                .body("I'm travelling to Uberlândia-MG")
                .build();

        Post post2 = Post.builder()
                .date(LocalDate.parse("25/05/2025", formatter))
                .author(new AuthorDTO(marcos))
                .title("Good Morning")
                .body("Howdy there! Good morning to you all")
                .build();

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
