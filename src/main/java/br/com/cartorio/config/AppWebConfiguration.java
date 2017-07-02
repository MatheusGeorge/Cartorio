package br.com.cartorio.config;

import br.com.cartorio.dao.CartorioDAO;
import br.com.cartorio.model.Cartorio;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.cartorio.controller.HomeController;

@EnableWebMvc
@ComponentScan(basePackageClasses={HomeController.class, CartorioDAO.class, Cartorio.class})
public class AppWebConfiguration {

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
}