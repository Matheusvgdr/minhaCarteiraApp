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
import model.Conta;
import service.ContaService;

public class ContaResource {

	// PROCURAR CONTA
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("procurarConta")
	public Response getProcurarConta(@QueryParam("idConta") int idConta) {

		ContaService servico = new ContaService();
		Conta conta = servico.procurarConta(idConta);

		return Response.ok().entity(conta).build();
	}

	// CADASTRAR CONTA
	@POST
	@Path("cadastrarConta")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postCadastrarConta(Conta conta) {

		ContaService servico = new ContaService();
		boolean resposta = servico.cadastrarConta(conta);

		return Response.status(200).entity(resposta).build();
	}

	// DELETAR CONTA
	@DELETE
	@Path("deletarConta")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postDeletarConta(@QueryParam("idConta") int idConta) {

		ContaService servico = new ContaService();
		boolean resposta = servico.deletarConta(idConta);

		return Response.status(200).entity(resposta).build();
	}

	// MODIFICAR CONTA
	@POST
	@Path("modificarConta")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postModificarConta(Conta conta) {

		ContaService servico = new ContaService();
		boolean resposta = servico.modificarConta(conta);

		return Response.status(200).entity(resposta).build();
	}

	// VERIFICAR CONTA
	@GET
	@Path("VerificarConta")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getVerificarConta(@QueryParam("nomeUsu") String nomeUsu, @QueryParam("senha") String senha) {

		ContaService servico = new ContaService();
		Conta resposta = servico.verificarConta(nomeUsu, senha);

		return Response.status(200).entity(resposta).build();
	}
}