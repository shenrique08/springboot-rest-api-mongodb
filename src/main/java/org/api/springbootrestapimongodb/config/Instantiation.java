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
import java.util.Collections;

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
                .author(new AuthorDTO(lucas))
                .title("Good Morning")
                .body("Howdy there! Good morning to you all")
                .build();

        Post post3 = Post.builder()
                .date(LocalDate.parse("04/02/2025", formatter))
                .author(new AuthorDTO(marcos))
                .title("Howdy")
                .body("Howdy there")
                .build();

        Post post4 = Post.builder()
                .date(LocalDate.parse("11/02/2025", formatter))
                .author(new AuthorDTO(marcos))
                .title("Yep")
                .body("Yep there")
                .build();
        postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));

        User anaFromDb = userRepository.findById(ana.getId()).orElseThrow();
        User lucasFromDb = userRepository.findById(lucas.getId()).orElseThrow();
        User marcosFromDb = userRepository.findById(marcos.getId()).orElseThrow();

        anaFromDb.getPosts().add(post1);
        lucasFromDb.getPosts().add(post2);
        marcosFromDb.getPosts().addAll(Arrays.asList(post3, post4));

        userRepository.saveAll(Arrays.asList(anaFromDb, lucasFromDb, marcosFromDb));
    }
}
