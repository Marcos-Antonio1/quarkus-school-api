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

import br.ada.treinamento.dto.AlunoDto;
import br.ada.treinamento.service.AlunoService;

@Path("/alunos")
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResource {

    private AlunoService service;

    @Inject
    public AlunoResource(AlunoService service){
        this.service = service;
    }
    
    @GET
    public Response listaAlunos(){
        
      return Response.status(Response.Status.OK)
      .entity(this.service.retrieveAll())
      .build();  
    }

    @GET
    @Path("/{id}")
    public Response listarAlunoPorId(@PathParam("id") int id){
        
        return Response.status(Response.Status.OK)
        .entity(this.service.getById(id))
        .build();  
    }

    @POST
    public Response cadastrarAluno(AlunoDto alunoDto){

        this.service.save(alunoDto);

        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizaAluno(AlunoDto alunoDto, @PathParam("id") int id){
        
        this.service.alterar(id, alunoDto);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeAluno(@PathParam("id") int id){
        this.service.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
