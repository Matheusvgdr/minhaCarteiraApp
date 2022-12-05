package myWallet.app;

import java.util.List;

import jakarta.ws.rs.Consumes;
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

	// Insere uma transação no banco de dados
	@POST
	@Path("realizarTransacao")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postRealizarTransacao(Movimentacao mov) {

		MovimentacaoService servico = new MovimentacaoService();
		boolean resposta;
		
		resposta = servico.realizarTransacao(mov);
			
		
		return Response.status(200).entity(resposta).build();

	}

	// Retorna um JSON com uma lista de saques feitos por um determinado usuário
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarSaques")
	public Response getSaque(@QueryParam("idConta") int idConta,@QueryParam("idTipo") int idTipo) {

		MovimentacaoService servico = new MovimentacaoService();
		List<Movimentacao> listaDeSaques = servico.listarSaques(idConta, idTipo);

		Response response = Response.ok().entity(listaDeSaques).build();

		return response;
	}

	// Retorna um JSON com uma lista de depósitos feito por um determinado usuário
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarDepositos")
	public Response getDeposito(@QueryParam("idConta") int idConta, @QueryParam("idTipo") int idTipo) {

		MovimentacaoService servico = new MovimentacaoService();
		List<Movimentacao> listaDeDepositos = servico.listarDepositos(idConta, idTipo);

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
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("realizarTransacaoCarteira")
	public Response postRealizarTransacaoCarteira(Movimentacao movi) {

		MovimentacaoService servico = new MovimentacaoService();
		boolean resposta = servico.realizarTransacaoCarteira(movi);
		
		return Response.ok(200).entity(resposta).build();
	}

}
