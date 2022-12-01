package myWallet.app;

import java.util.List;

import jakarta.ws.rs.GET;
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
	
	//Retorna um json com uma lista das Transações de uma determinada conta
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarMovimentacao")
    public Response getMovimentacao(@QueryParam("idConta") int idConta) {
    	
    	MovimentacaoService servico = new MovimentacaoService();
    	List<Movimentacao> listaDeMovimentacao = servico.listarTransacoes(idConta);
    	
    	Response response = Response.ok().entity(listaDeMovimentacao).build();
    	
    	return response;
    }
}
