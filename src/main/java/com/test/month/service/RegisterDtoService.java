package com.test.month.service;

import com.test.month.data.ValueDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class RegisterDtoService {
    @Bean
    public ValueDTO getDto(){
        return new ValueDTO();
    }
}
