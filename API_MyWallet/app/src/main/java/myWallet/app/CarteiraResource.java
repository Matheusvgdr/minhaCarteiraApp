package myWallet.app;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Carteira;
import service.CarteiraService;
import jakarta.ws.rs.QueryParam;

@Path("carteira")
public class CarteiraResource {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}
	
	@POST
	@Path("cadastrarCarteira")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postCadastrarCarteira(Carteira cart) {
		
		CarteiraService servico = new CarteiraService();
		boolean resposta = servico.cadastrarCarteira(cart);
		
		return Response.status(200).entity(resposta).build();
	}
	
	@DELETE
	@Path("deletarCarteira")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postDeletarCarteira(@QueryParam("idCarteira") int idCarteira) {
		
		CarteiraService servico = new CarteiraService();
		boolean resposta = servico.deletarCarteira(idCarteira);
		
		return Response.status(200).entity(resposta).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarCarteiras")
	public Response getListarCarteiras(@QueryParam("idConta") int idConta) {
		
		CarteiraService servico = new CarteiraService();
		List<Carteira> listaDeCarteiras = servico.listarCarteiras(idConta);
				
		return Response.ok().entity(listaDeCarteiras).build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("procurarCarteira")
	public Response getProcurarCarteira(@QueryParam("idCarteira") int idCarteira) {
		
		CarteiraService servico = new CarteiraService();
		Carteira carteira = servico.procurarCarteira(idCarteira);
		
		return Response.ok().entity(carteira).build();
	
	}
	
	@POST
	@Path("modificarCarteira")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postModificarCarteira(Carteira cart){
		
		CarteiraService servico = new CarteiraService();
		boolean resposta = servico.modificarCarteira(cart);
		
		return Response.status(200).entity(resposta).build();
		
	}
}
