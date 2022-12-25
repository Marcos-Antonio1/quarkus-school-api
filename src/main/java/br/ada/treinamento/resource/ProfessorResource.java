package br.ada.treinamento.resource;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.ada.treinamento.dto.DisciplinaResponse;
import br.ada.treinamento.dto.ErrorResponse;
import br.ada.treinamento.dto.ProfessorRequest;
import br.ada.treinamento.entity.Disciplina;
import br.ada.treinamento.service.ProfessorService;



@Path("/professores")
@Produces(MediaType.APPLICATION_JSON)
public class ProfessorResource {
    
    
    private  ProfessorService service;

    @Inject
    public ProfessorResource(ProfessorService service){
        this.service = service;
    } 
    
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
    public Response cadastrarProfessor(ProfessorRequest professorRequest){
        try{
            this.service.save(professorRequest);
            return Response.status(Response.Status.CREATED)
            .build();
        }catch(ConstraintViolationException e){
            return Response.status(Response.Status.BAD_REQUEST)
            .entity(ErrorResponse.createFromValidation(e))
            .build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizaProfessor(ProfessorRequest professorRequest, @PathParam("id") int id){
        try{
            this.service.alterar(id, professorRequest);
            return Response.status(Response.Status.OK)
            .build();
        }catch(ConstraintViolationException e){
            return Response.status(Response.Status.BAD_REQUEST)
            .entity(ErrorResponse.createFromValidation(e))
            .build();
        }
        
    }

    @DELETE
    @Path("/{id}")
    public Response removeProfessor(@PathParam("id") int id){
        this.service.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/{id-professor}/disciplina")
    public Response listarDisciplinaNaQualETitular(@PathParam("id-professor") int id){
        return Response.status(Response.Status.OK).entity(service.listarDisciplinaNaQualETitular(id)).build();
    }


}
