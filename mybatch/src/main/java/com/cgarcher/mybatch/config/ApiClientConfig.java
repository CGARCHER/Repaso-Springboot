package com.cgarcher.mybatch.config;


import org.generator.ApiClient;
import org.generator.api.StudentControllerApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiClientConfig {

    @Value("${apiclient.student.url}")
    private String url;

    @Bean
    public ApiClient apiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(url); // URL base de la API
        return apiClient;
    }

    @Bean
    public StudentControllerApi studentControllerApi(ApiClient apiClient) {
        return new StudentControllerApi(apiClient);
    }
}