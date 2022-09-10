/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.duy.configs;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.duy.formatters.FacultyFormatter;
import com.duy.formatters.ThesisFormatter;
import com.duy.formatters.UserFormatter;
import com.duy.validator.WebAppValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 *
 * @author Admin
 */
@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.duy.controllers",
    "com.duy.repository",
    "com.duy.service",
    "com.duy.formatters",
    "com.duy.validator"}
)
public class WebAppContextConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer conf) {
        conf.enable();
    }

    @Override
    public void addFormatters(FormatterRegistry r) {
        r.addFormatter(new FacultyFormatter());
        r.addFormatter(new ThesisFormatter());
        r.addFormatter(new UserFormatter());
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver
                = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("UTF-8");
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource m = new ResourceBundleMessageSource();
        m.setBasenames("messages");

        return m;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean
                = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }
    
    @Override
    public Validator getValidator() {
        return validator();
    }
    
    @Bean
    public WebAppValidator webAppValidator() {
//        Set<Validator> springValidators = new HashSet<>();
//        springValidators.add(new FacultyValidator());

        WebAppValidator validator = new WebAppValidator();
//        validator.setSpringValidators(springValidators);

        return validator;
    }

//    @Bean
    //    public CommonsMultipartResolver multipartResolver() {
    //        CommonsMultipartResolver resolver
    //                = new CommonsMultipartResolver();
    //        resolver.setDefaultEncoding("UTF-8");
    //        return resolver;
    //    }
    //
    //    @Bean
    //    public Cloudinary cloudinary() {
    //        Cloudinary c
    //                = new Cloudinary(ObjectUtils.asMap(
    //                        "cloud_name", "dbkgejwir",
    //                        "api_key", "554948912897578",
    //                        "api_secret", "QcKy_revxg7TxR5165aFj-wCfHY",
    //                        "secure", true));
    //        return c;
    //    }
    //
    //    @Bean
    //    public InternalResourceViewResolver viewResolver() {
    //        InternalResourceViewResolver r = new InternalResourceViewResolver();
    //        r.setViewClass(JstlView.class);
    //        r.setPrefix("/WEB-INF/jsp/");
    //        r.setSuffix(".jsp");
    //
    //        return r;
    //    }
}
