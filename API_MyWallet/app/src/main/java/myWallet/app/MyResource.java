package myWallet.app;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Movimentacao;
import service.MovimentacaoService;

	@Path("myresource")
	public class MyResource {
	    @GET
	    @Produces(MediaType.TEXT_PLAIN)
	    public String getIt() {
	        return "Got it!";
	    }
	    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarMovimentacao")
    public Response getMovimentacao(int idConta) {
    	
    	MovimentacaoService servico = new MovimentacaoService();
    	List<Movimentacao> listaDeMovimentacao = servico.litarTransacoes(idConta);
    	
    	Response response = Response.ok().entity(listaDeMovimentacao).build();
    	
    	return response;
    	
    }
}
