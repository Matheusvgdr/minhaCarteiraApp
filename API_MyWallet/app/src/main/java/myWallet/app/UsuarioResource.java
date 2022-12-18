package myWallet.app;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Usuario;
import service.UsuarioService;

@Path("usuario")
public class UsuarioResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("procurarUsuario")
	public Response getProcurarUsuario(@QueryParam("idUsuario") int idUsuario) {
		
		UsuarioService servico = new UsuarioService();
		Usuario usuario = servico.procurarUsuario(idUsuario);
		
		return Response.ok().entity(usuario).build();
	
	}
	
	@POST
	@Path("cadastrarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postCadastrarUsuario(Usuario user) {
		
		UsuarioService servico = new UsuarioService();
		boolean resposta = servico.cadastrarUsuario(user);
		
		return Response.status(200).entity(resposta).build();
	}
	
	@DELETE
	@Path("deletarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postDeletarUsuario(@QueryParam("idUsuario") int idUsuario) {
		
		UsuarioService servico = new UsuarioService();
		boolean resposta = servico.deletarUsuario(idUsuario);
		
		return Response.status(200).entity(resposta).build();
	}
	
	@POST
	@Path("modificarUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postModificarUsuario(Usuario usu){
		
		UsuarioService servico = new UsuarioService();
		boolean resposta = servico.modificarUsuario(usu);
		
		return Response.status(200).entity(resposta).build();
		
	}
}
