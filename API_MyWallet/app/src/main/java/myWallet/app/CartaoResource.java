package myWallet.app;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Cartao;
import service.CartaoService;

public class CartaoResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarCartao")
	public Response getCartao(@QueryParam("idCartao") int idCartao) {

		CartaoService servico = new CartaoService();
		List<Cartao> listaDeCartao = servico.listarCartao();

		Response response = Response.ok().entity(listaDeCartao).build();

		return response;
	}
}