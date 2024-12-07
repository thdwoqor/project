package gg.your.project.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("gg.your.project.infra")
public class OpenFeignConfig {
}
