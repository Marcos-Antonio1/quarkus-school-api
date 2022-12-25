package br.ada.treinamento.resource;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import br.ada.treinamento.dto.DisciplinaRequest;
import br.ada.treinamento.service.DisciplinaService;

@Path("/discliplinas")
public class DiscliplinaResource {

    private DisciplinaService service;

    @Inject
    public DiscliplinaResource(DisciplinaService service){
        this.service = service;
    }
    
    @GET
    public Response listaDisciplinas(){
      
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
    public Response cadastrarCurso(DisciplinaRequest    cursoRequest){
        
        this.service.save(cursoRequest);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response atualizaCurso(DisciplinaRequest disciplinaRequest, @PathParam("id") int id){
        this.service.alterar(id, disciplinaRequest);
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("/{id}")
    public Response removeCurso(@PathParam("id") int id){
        this.service.deletar(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
