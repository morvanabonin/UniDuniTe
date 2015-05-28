
package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Projeto;

/**
 * Classe de Crud de Projeto
 * implements da interface IProjetoDao
 * 
 * @author morvanabonin
 */
public class ProjetoDaoBD implements IProjetoDao {
    
    private Connection conexao;
    private PreparedStatement comando;
    private String sql;
    
   /**
    * Método de inserção de um projeto no bd
    * @param projeto 
    * @throws java.lang.Exception 
    */
    @Override
    public void inserir(Projeto projeto) throws Exception {
	if (this._validaCodigo(projeto.getCodigo())) {
	   throw new Exception("Código já existe no Banco de Dados"); 
	} else {
	    try {
		sql = "INSERT INTO projeto(codigo, nome, dt_inicio, dt_fim, aberto, descricao) VALUES (?, ?, ?, ?, ?, ?)";
		conectar(sql);
		comando.setInt(1, projeto.getCodigo());
		comando.setString(2, projeto.getNome());
		comando.setDate(3, projeto.getDt_inicio());
		comando.setDate(4, projeto.getDt_fim());
		comando.setBoolean(5, projeto.isAberto());
		comando.setString(6, projeto.getDescricao());
		comando.executeUpdate();
		fechar();

	    } catch (ClassNotFoundException | SQLException ex) {
		Logger.getLogger(ProjetoDaoBD.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }

    /**
    * Método de deleção de um projeto no bd
    * @param codigo 
    */
    @Override
    public void deletar(int codigo) {
	try {
            sql = "DELETE FROM projeto WHERE codigo=?";
	    conectar(sql);
	    comando.setInt(1, codigo);
	    comando.executeUpdate();
	    fechar(); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjetoDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
    * Método de atualização de um projeto no bd
    * @param codigo
    * @param projeto 
    */
    @Override
    public void atualizar(int codigo, Projeto projeto) {
	try {
	    sql = "UPDATE projeto SET codigo=?, nome=?, dt_inicio=?, dt_fim=?, aberto=?, descricao=? WHERE codigo=?";
            conectar(sql);
            comando.setInt(1, projeto.getCodigo());
            comando.setString(2, projeto.getNome());
	    comando.setDate(3, projeto.getDt_inicio());
	    comando.setDate(4, projeto.getDt_fim());
	    comando.setBoolean(5, projeto.isAberto());
	    comando.setString(6, projeto.getDescricao());
	    comando.setInt(7, codigo);
            comando.executeUpdate();
            fechar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProjetoDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Projeto> listar() {
	return null;
    }
    
    /**
     * Validação se já existe o código no banco de dados
     * 
     * @param codigo
     * @return true se codigo já existe | false se não existe
     */
    private boolean _validaCodigo(int codigo) {
	try {
	    sql = "SELECT codigo FROM projeto WHERE codigo = ?";
	    conectar(sql);
	    comando.setInt(1, codigo);
	    ResultSet resultado = comando.executeQuery();
	    if (resultado.next()) {
		return true;
	    }
	    fechar();
	} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
	return false;
    }
    
    private void conectar(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql);
    }
    
    public void fechar() throws SQLException {
        comando.close();
        conexao.close();
    }

}
