package br.ada.treinamento;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;

@OpenAPIDefinition(
    tags = {
        @Tag(name="Alunos endpoints")
    },
    info = @Info(
        title="Example API",
        version = "1.0.1")
)
public class ApiApplication extends Application {
    
}
