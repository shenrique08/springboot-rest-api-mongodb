package org.api.springbootrestapimongodb.config;

import org.api.springbootrestapimongodb.domain.User;
import org.api.springbootrestapimongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public Instantiation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User ana = User.builder().name("Ana Clara Souza").email("ana.souza@example.com").build();
        User lucas = User.builder().name("Lucas Oliveira Costa").email("lucas.costa@example.com").build();
        User juliana = User.builder().name("Juliana Santos Pereira").email("juliana.pereira@example.com").build();
        User marcos = User.builder().name("Marcos Lima Ferreira").email("marcos.ferreira@example.com").build();

        userRepository.saveAll(Arrays.asList(ana, lucas, juliana, marcos));

    }
}
