package br.ada.treinamento.resource;

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

import br.ada.treinamento.dto.AlunoRequest;
import br.ada.treinamento.dto.ErrorResponse;
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
    public Response cadastrarAluno(AlunoRequest alunoRequest){
        try{
            this.service.save(alunoRequest);

            return Response.status(Response.Status.CREATED).build();
        }catch(ConstraintViolationException e){
            return Response.
                    status(Response.Status.BAD_REQUEST)
                    .entity(ErrorResponse.createFromValidation(e))
                    .build();
        }
        
    }

    @PUT
    @Path("/{id}")
    public Response atualizaAluno(AlunoRequest alunoRequest, @PathParam("id") int id){
        try{
            this.service.alterar(id, alunoRequest);
            return Response.status(Response.Status.OK).build();
        }catch(ConstraintViolationException e){
            return Response.
                    status(Response.Status.BAD_REQUEST)
                    .entity(ErrorResponse.createFromValidation(e))
                    .build();
        }
        
    }

    @DELETE
    @Path("/{id}")
    public Response removeAluno(@PathParam("id") int id){
        this.service.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @PUT
    @Path("/{id-aluno}/tutor/{id-tutor}")
    public Response cadastrarTutorParaAluno(@PathParam("id-aluno")int idAluno,@PathParam("id-tutor") int idTutor){
        this.service.cadastrarTutorParaAluno(idAluno, idTutor);
        return Response.status(Response.Status.OK).build();
    }

}
