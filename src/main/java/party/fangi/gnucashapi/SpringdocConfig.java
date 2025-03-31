package party.fangi.gnucashapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponses;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.utils.SpringDocUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.TreeMap;

@Configuration
@OpenAPIDefinition(servers = {
        @Server(url = "http://localhost:${server.port}/", description = "GnuCash API definition")
})
public class SpringdocConfig {

    @Bean
    public GroupedOpenApi swagger() {
        // enable maps as @RequestPart
        SpringDocUtils.getConfig().removeRequestWrapperToIgnore(java.util.Map.class);

        return GroupedOpenApi.builder()
                .group("GnuCash API")
                .pathsToMatch("/**")
                .addOpenApiCustomizer(openApi -> {
                    openApi.getInfo()
                            .title("GnuCash API")
                            .version("1.0");
                    // Add security schemes
                    openApi.getComponents()
                            .addSecuritySchemes("bearer", new SecurityScheme()
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("bearer"))
                            .addSecuritySchemes("basic", new SecurityScheme()
                                    .type(SecurityScheme.Type.HTTP)
                                    .scheme("basic"));
                })

                // sort endpoints alphabetically
                .addOpenApiCustomizer(openApi -> openApi.getPaths().keySet().stream()
                        .sorted()
                        .forEachOrdered(path -> {
                            var value = openApi.getPaths().remove(path);
                            openApi.getPaths().put(path, value);
                        }))

                // sort schemas alphabetically
                .addOpenApiCustomizer(openApi -> {
                    Map<String, Schema> sortedSchemas = new TreeMap<>(openApi.getComponents().getSchemas());
                    openApi.getComponents().setSchemas(sortedSchemas);
                })

                // sort responses by status code
                .addOpenApiCustomizer(openApi -> openApi.getPaths().values().forEach(pathItem ->
                        pathItem.readOperations().forEach(operation -> {
                            if (operation.getResponses() != null) {
                                var sortedResponses = new ApiResponses();
                                operation.getResponses().entrySet().stream()
                                        .sorted(Map.Entry.comparingByKey())
                                        .forEach(apiResponse ->
                                                sortedResponses.addApiResponse(apiResponse.getKey(), apiResponse.getValue())
                                        );
                                operation.setResponses(sortedResponses);
                            }
                        })))

                .build();

    }

    @Bean
    public OpenAPI baseOpenApi() {
        return new OpenAPI()
                .info(new Info().title("GnuCash API"));
    }

}
