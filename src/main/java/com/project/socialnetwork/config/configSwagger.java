package com.project.socialnetwork.config;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
   
		info = @Info(
				title="API Social Network",
				version = "1.0.0",
				contact = @Contact(
						 name = "Mário Júnior",
						 url = "https://github.com/Mario23junior/Social-Network-api#readme",
						 email = "mariojunior3251@gmail.com"
						),
			      license = @License(
			              name = "Apache 2.0",
			              url = "https://www.apache.org/licenses/LICENSE-2.0.html")
				
			)
)
public class configSwagger extends  Application{

}
