package br.ada.treinamento.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.ada.treinamento.dto.CursoDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
public class CursoResource {
    
    @GET
    public Response listaCursos(){
      log.info("listando cursos");
      
      return Response
            .status(Response.Status.OK).build();  
    }

    @GET
    @Path("/{id}")
    public Response listarCursoPorId(@PathParam("id") int id){
        log.info("listando o curso {}", id);

        return Response
            .status(Response.Status.OK).build();  
    }

    @POST
    public Response cadastrarCurso(CursoDto cursoDto){
        log.info("Cadastrando curso {} ", cursoDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizaCurso(CursoDto cursoDto, @PathParam("id") int id){
        log.info("atualizando o curso de id {}", id);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeCurso(@PathParam("id") int id){
        log.info("deletando o curso de id {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
