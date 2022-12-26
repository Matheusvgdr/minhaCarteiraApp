package myWallet.app;

import java.util.List;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.TipoTransacao;
import service.TipoTransacaoService;

@Path("tipoTransacao")
public class TipoTransacaoResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarTipoTransacao")
	public Response getCartao(@QueryParam("idTipoTransacao") int idTipoTransacao) {

		TipoTransacaoService servico = new TipoTransacaoService();
		List<TipoTransacao> listaDeTipoTransacao = servico.listarTipos();

		Response response = Response.ok().entity(listaDeTipoTransacao).build();

		return response;
	}
}