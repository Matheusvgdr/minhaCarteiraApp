package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cartao;
import model.Carteira;
import model.Conta;
import model.Lista;

public class ListaDAO {
	
	Connection conex = null;
	PreparedStatement ps;
	
	/*public List<Lista> visualizarLista(int id){
		List<Lista> lista = new ArrayList<Lista>();
		Lista li;
		ResultSet rs = null;
		conex = DAO.criarConexao();
		String sql = "SELECT * FROM tb_lista WHERE id_carteira = ?";
		
		try {
			
			ps = conex.prepareStatement(sql);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				/*Conta conta = new Conta();
				Carteira cart = new Carteira();
				Cartao cartao = new Cartao();
				
				li = new Lista();
				
				li.setConteudo(rs.getString("conteudo"));
				li.setDinheiro(rs.getDouble("dinheiro"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}*/
}
