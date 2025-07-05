package com.bsmlabs.rag.config;

import com.bsmlabs.rag.service.in28minutesService;
import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppRagConfig {

    /**
     * The ToolCallbacks.from() method scans the service class for @Tool annotations and registers them with the MCP framework.
     */
    @Bean
    public List<ToolCallback> in28minutesTools(in28minutesService service) {
        return List.of(ToolCallbacks.from(service));
    }
}
