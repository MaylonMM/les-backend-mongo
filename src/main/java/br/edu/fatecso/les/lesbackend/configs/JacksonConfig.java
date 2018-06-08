package br.edu.fatecso.les.lesbackend.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.fatecso.les.lesbackend.domain.PagamentoComCartao;
import br.edu.fatecso.les.lesbackend.domain.PagamentoComDinheiro;

@Configuration
public class JacksonConfig {
	
	@Bean
	public Jackson2ObjectMapperBuilder objectMapperBuilder() {
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder() {
			public void configure(ObjectMapper objectMapper) {
				objectMapper.registerSubtypes(PagamentoComCartao.class);
				objectMapper.registerSubtypes(PagamentoComDinheiro.class);
				super.configure(objectMapper);
			}
		};
		return builder;
	}
}
