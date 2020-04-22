package com.tryputs.backend.configuration;

import com.tryputs.backend.dto.AuthorDto;
import com.tryputs.backend.dto.GenreDto;
import com.tryputs.backend.entity.Author;
import com.tryputs.backend.entity.Genre;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;

@Configuration
public class CommonConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
            .setMatchingStrategy(MatchingStrategies.STRICT)
            .setFieldMatchingEnabled(true)
            .setSkipNullEnabled(true)
            .setFieldAccessLevel(PRIVATE);
        mapper.addMappings(new PropertyMap<Author, AuthorDto>() {
            @Override
            protected void configure() {
                skip(destination.getBooks());
            }
        });
        mapper.addMappings(new PropertyMap<Genre, GenreDto>() {
            @Override
            protected void configure() {
                skip(destination.getBooks());
            }
        });
        return mapper;
    }
}
