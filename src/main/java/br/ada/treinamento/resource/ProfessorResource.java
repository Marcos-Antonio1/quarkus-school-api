package br.ada.treinamento.resource;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.ada.treinamento.dto.ProfessorDto;
import br.ada.treinamento.service.ProfessorService;



@Path("/professores")
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorResource {
    
    @Inject
    private  ProfessorService service;

    /* @Inject
    public ProfessorResource(ProfessorService service){
        this.service = service;
    } */
    
    @GET
    public Response listaProfessores(){

      return Response.status(Response.Status.OK)
            .entity(this.service.retrieveAll())
            .build();  

    }

    @GET
    @Path("/{id}")
    public Response listarProfessorPorId(@PathParam("id") int id){

        return Response.status(Response.Status.OK)
        .entity(this.service.getById(id))
        .build();  
    }

    @POST
    public Response cadastrarProfessor(ProfessorDto professorDto){
        
        this.service.save(professorDto);
        return Response.status(Response.Status.CREATED)
        .build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizaProfessor(ProfessorDto professorDto, @PathParam("id") int id){
        
        this.service.alterar(id, professorDto);
        return Response.status(Response.Status.OK)
        .build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeProfessor(@PathParam("id") int id){
        this.service.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
