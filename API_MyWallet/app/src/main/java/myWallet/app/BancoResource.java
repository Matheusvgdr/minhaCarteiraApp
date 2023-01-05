package myWallet.app;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Banco;
import service.BancoService;

@Path("cartao")
public class BancoResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarBancos")
	public Response getCartao() {

		BancoService servico = new BancoService();
		List<Banco> listaDeCartao = servico.listarBancos();

		Response response = Response.ok().entity(listaDeCartao).build();

		return response;
	}
}