package br.ada.treinamento.resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.ada.treinamento.dto.ProfessorDto;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Path("/professores")
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorResource {
    
    @GET
    public Response listaProfessores(){
      log.info("listando professores");
      
      return Response
            .status(Response.Status.OK).build();  
    }

    @GET
    @Path("/{id}")
    public Response listarProfessorPorId(@PathParam("id") int id){
        log.info("listando o professor {}", id);

        return Response
            .status(Response.Status.OK).build();  
    }

    @POST
    public Response cadastrarProfessor(ProfessorDto professorDto){
        log.info("Cadastrando professor {} ", professorDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizaProfessor(ProfessorDto professorDto, @PathParam("id") int id){
        log.info("atualizando o professor de id {}", id);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeProfessor(@PathParam("id") int id){
        log.info("deletando o professor de id {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
