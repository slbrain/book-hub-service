package bookshub.demo.config;

import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket swaggerConfiguration(ServletContext servletContext) {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.forCodeGeneration(true)
                .useDefaultResponseMessages(false)
                .globalResponseMessage(RequestMethod.POST, new ArrayList<>())
                .select()
                .apis(RequestHandlerSelectors.basePackage("bookshub.demo"))
                .build().apiInfo(apiInfo());
		
		
	}
	
	 private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Bookshub API")
	                .description("")
	                .version("v.1")
	                .build();

	    }

}
