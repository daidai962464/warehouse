package com.warehouse.config.exception;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/16 20:27
 */
@Configuration
public class ContainerConfig {

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new Customizer();
    }

    private static class Customizer implements EmbeddedServletContainerCustomizer {
        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/404"));
        }
    }
}
