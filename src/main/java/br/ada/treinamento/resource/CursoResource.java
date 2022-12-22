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

import br.ada.treinamento.dto.CursoRequest;
import br.ada.treinamento.service.CursoService;


@Path("/cursos")
@Produces(MediaType.APPLICATION_JSON)
public class CursoResource {
    
    private CursoService service;

    @Inject
    public CursoResource(CursoService service){
        this.service = service;
    }

    @GET
    public Response listaCursos(){
      
      return Response.status(Response.Status.OK)
      .entity(this.service.retrieveAll())
      .build();  
    }

    @GET
    @Path("/{id}")
    public Response listarCursoPorId(@PathParam("id") int id){

        return Response.status(Response.Status.OK)
        .entity(this.service.getById(id))
        .build();  
    }

    @POST
    public Response cadastrarCurso(CursoRequest cursoRequest){
        
        this.service.save(cursoRequest);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizaCurso(CursoRequest cursoRequest, @PathParam("id") int id){
        this.service.alterar(id, cursoRequest);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeCurso(@PathParam("id") int id){
        this.service.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}
