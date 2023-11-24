package de.gamue;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import de.gamue.fizzbuzz.ErrorResponse;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.media.Content;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.utils.SpringDocAnnotationsUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class OpenApiConfig {

  @Bean
  public OpenAPI publicApi() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Playground APIs")
                .description("Documentation of the REST APIs")
                .version("1.0"));
  }

  @Bean
  public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser(OpenAPI api) {
    return openApi -> {
      openApi
          .getPaths()
          .values()
          .forEach(
              pathItem ->
                  pathItem
                      .readOperations()
                      .forEach(
                          operation -> {
                            ApiResponses apiResponses = operation.getResponses();
                            ApiResponse badRequestError = getErrorResponse("Bad Request", api);
                            apiResponses.addApiResponse(
                                String.valueOf(HttpStatus.BAD_REQUEST.value()), badRequestError);
                          }));
    };
  }

  private ApiResponse getErrorResponse(String description, OpenAPI api) {
    Schema errorResponseSchema =
        SpringDocAnnotationsUtils.extractSchema(
            api.getComponents(), ErrorResponse.class, null, null);
    MediaType mediaType = new MediaType().schema(errorResponseSchema);
    return new ApiResponse()
        .description(description)
        .content(new Content().addMediaType(APPLICATION_JSON_VALUE, mediaType));
  }
}
