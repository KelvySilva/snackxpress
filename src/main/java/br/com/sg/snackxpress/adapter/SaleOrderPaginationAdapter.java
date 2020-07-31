package br.com.sg.snackxpress.adapter;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
    public class SaleOrderPaginationAdapter implements WebMvcConfigurer {
        @Override
        public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
            PageableHandlerMethodArgumentResolver resolver = new PageableHandlerMethodArgumentResolver();
            resolver.setFallbackPageable(PageRequest.of(0, 10, Sort.by("id")));
            resolvers.add(resolver);
        }
    }