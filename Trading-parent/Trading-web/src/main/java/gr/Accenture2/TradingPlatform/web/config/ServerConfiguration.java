package gr.Accenture2.TradingPlatform.web.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Billy
 * I added this class only to configure http://localhost:8080/resources/
 */
@Configuration
@EnableWebMvc
@ComponentScan
@EntityScan(basePackages = {"gr.Accenture2.TradingPlatform.core.entity", "gr.Accenture2.TradingPlatform.repository.entity"})

@EnableJpaRepositories("gr.Accenture2.TradingPlatform.repository.service")
public class ServerConfiguration extends WebMvcAutoConfiguration{

}