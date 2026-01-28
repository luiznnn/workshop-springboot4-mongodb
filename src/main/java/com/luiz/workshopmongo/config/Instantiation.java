package com.luiz.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luiz.workshopmongo.domain.Post;
import com.luiz.workshopmongo.domain.User;
import com.luiz.workshopmongo.dto.AuthorDTO;
import com.luiz.workshopmongo.repository.PostRepository;
import com.luiz.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

@Autowired
    private PostRepository postRepository;

@Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User larissa = new User(null,"Larissa Silva", "larissa@gmail.com");
        User alex = new User(null,"Alex Green", "alex@gmail.com");
        User bob = new User(null,"Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(larissa, alex, bob));

        Post post1 =  new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo.Abraços!", new AuthorDTO(larissa));
        Post post2 =new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(larissa));

        
        postRepository.saveAll(Arrays.asList(post1, post2));

        larissa.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(larissa);

    }

}
