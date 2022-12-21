package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TipoTransacao;

public class TipoTransacaoDAO {
	
	Connection conex = null;
	public List<TipoTransacao> listarTipoTransacao() {
		
		List<TipoTransacao> listaTipos = new ArrayList<TipoTransacao>();
		ResultSet rs = null;
		TipoTransacao tipoT= null;
		conex = DAO.criarConexao();
		
		String sql = "SELECT * FROM tb_tipoTransacao;";
		
		
		try {
			PreparedStatement ps = conex.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				tipoT = new TipoTransacao();
				tipoT.setId(rs.getInt("id"));
				tipoT.setDescricao(rs.getString("descricao"));
				
				listaTipos.add(tipoT);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return listaTipos;
	}
}
