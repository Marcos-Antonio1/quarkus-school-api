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

import br.ada.treinamento.dto.AlunoDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/Alunos")
@Produces(MediaType.APPLICATION_JSON)
public class AlunoResource {
    
    @GET
    public Response listaAlunos(){
      log.info("listando alunos");
      
      return Response
            .status(Response.Status.OK).build();  
    }

    @GET
    @Path("/{id}")
    public Response listarAlunoPorId(@PathParam("id") int id){
        log.info("listando o aluno com id {}", id);

        return Response
            .status(Response.Status.OK).build();  
    }

    @POST
    public Response cadastrarAluno(AlunoDto alunoDto){
        log.info("Cadastrando aluno {} ", alunoDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizaAluno(AlunoDto alunoDto, @PathParam("id") int id){
        log.info("atualizando o Aluno de id {}", id);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeAluno(@PathParam("id") int id){
        log.info("deletando o Aluno de id {}", id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
