package myWallet.app;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.Lista;
import service.ListaService;

@Path("lista")
public class ListaResource {
	// PROCURAR ITEM
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("procurarItem")
	public Response getProcurarItem(@QueryParam("idLista") int idLista) {

		ListaService servico = new ListaService();
		Lista lista = servico.procurarItem(idLista);

		return Response.ok().entity(lista).build();
	}

	// CADASTRAR ITEM
	@POST
	@Path("cadastrarItem")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postCadastrarItem(Lista lista) {

		ListaService servico = new ListaService();
		boolean resposta = servico.cadastrarItem(lista);

		return Response.status(200).entity(resposta).build();
	}

	// DELETAR LISTA
	@DELETE
	@Path("deletarItem")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postDeletarItem(@QueryParam("idLista") int idLista) {

		ListaService servico = new ListaService();
		boolean resposta = servico.deletarLista(idLista);

		return Response.status(200).entity(resposta).build();
	}

	// MODIFICAR LISTA
	@POST
	@Path("modificarItem")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postModificarItem(Lista lista) {

		ListaService servico = new ListaService();
		boolean resposta = servico.modificarLista(lista);

		return Response.status(200).entity(resposta).build();
	}

	// LISTAR ITENS
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("listarItem")
	public Response getListarItem(@QueryParam("idLista") int idLista) {

		ListaService servico = new ListaService();
		List<Lista> listaDeItem = servico.listarItem(idLista);

		Response response = Response.ok().entity(listaDeItem).build();

		return response;
	}
}
