package myWallet.app;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Movimentacao;
import service.MovimentacaoService;
import jakarta.ws.rs.QueryParam;

@Path("myresource")
public class MyResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		return "Got it!";
	}

	// Encontra as movimentações relativas a determinado usuario

	// Insere uma transação no banco de dados
	/*
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("inserirTransacaoBD")
	public boolean postInserirTransacaoBD(@QueryParam("idConta") int idConta) {

		MovimentacaoService servico = new MovimentacaoService();

	}*/

	// Faz o calculo para determinar o saldo final do usuario
	/*
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("calculoSaldoFinal")
	public boolean postCalculoSaldoFinal(@QueryParam("idConta") int idConta) {

		MovimentacaoService servico = new MovimentacaoService();

	}
*/
	// Retorna um JSON com uma lista de saques feitos por um determinado usuário
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarSaques")
	public Response getSaque(@QueryParam("idConta") int idConta) {

		MovimentacaoService servico = new MovimentacaoService();
		List<Movimentacao> listaDeSaques = servico.listarSaques(idConta, idConta);

		Response response = Response.ok().entity(listaDeSaques).build();

		return response;
	}

	// Retorna um JSON com uma lista de depósitos feito por um determinado usuário
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarDepositos")
	public Response getDeposito(@QueryParam("idConta") int idConta) {

		MovimentacaoService servico = new MovimentacaoService();
		List<Movimentacao> listaDeDepositos = servico.listarDepositos(idConta, idConta);

		Response response = Response.ok().entity(listaDeDepositos).build();

		return response;
	}

	// Retorna um JSON com uma lista das Transações de uma determinada conta
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarMovimentacao")
	public Response getMovimentacao(@QueryParam("idConta") int idConta) {

		MovimentacaoService servico = new MovimentacaoService();
		List<Movimentacao> listaDeMovimentacao = servico.listarTransacoes(idConta);

		Response response = Response.ok().entity(listaDeMovimentacao).build();

		return response;
	}

	// Insere uma transação realizada para uma carteira, que pertence a um usuário
	/*
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("inserirTransacaoCarteira")
	public boolean postInserirTransacaoCarteira(@QueryParam("idConta") int idConta) {

		MovimentacaoService servico = new MovimentacaoService();

	}*/

}
