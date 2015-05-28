package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Competencia;

/**
 * Classe de Crud de Competencia 
 * implements da interface ICompetenciaDao
 *
 * @author morvanabonin
 */
public class CompetenciaDaoBD implements ICompetenciaDao {
    
    private Connection conexao;
    private PreparedStatement comando;
    private String sql;  
    private int id;
    
    /**
    * Método de inserção de uma competencia no bd
    * @param competencia 
     * @throws java.lang.Exception 
    */
    @Override
    public void inserir(Competencia competencia) throws Exception {
	
	if (this._validaCodigo(competencia.getCodigo())) {
	    throw new Exception("Codigo já existe no Banco de Dados");
	    
	} else {
	    try {
		sql = "INSERT INTO competencia(codigo, nome) VALUES (?, ?)";
		conectar(sql);
		comando.setString(1, competencia.getCodigo());
		comando.setString(2, competencia.getNome());
		comando.executeUpdate();
		fechar();
	    } catch (ClassNotFoundException | SQLException ex) {
		Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    /**
    * Método de deleção de uma competencia no bd
    * @param competencia 
    */
    @Override
    public void deletar(Competencia competencia) {
	id = _pegaIdCompetenciaPorCodigo(competencia);
	try {
            sql = "DELETE FROM competencia WHERE id=?";
	    conectar(sql);
	    comando.setInt(1, id);
	    comando.executeUpdate();
	    fechar(); 
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
	
    }
    
    /**
    * Método de atualização de uma competencia no bd
    * @param competencia 
    */
    @Override
    public void atualizar(Competencia competencia) {
	id = this._pegaIdCompetenciaPorCodigo(competencia);
        try {
	    sql = "UPDATE competencia SET codigo=?, nome=? WHERE id=?";
            conectar(sql);
            comando.setString(1, competencia.getCodigo());
            comando.setString(2, competencia.getNome());
	    comando.setInt(3, id);
            comando.executeUpdate();
            fechar();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método de atualização por id de uma competencia no bd
     * 
     * @param id
     * @param competencia
     */
    @Override
    public void atualizarPorId(int id, Competencia competencia) {
        try {
	    sql = "UPDATE competencia SET codigo=?, nome=? WHERE id=?";
            conectar(sql);
            comando.setString(1, competencia.getCodigo());
            comando.setString(2, competencia.getNome());
	    comando.setInt(3, id);
            comando.executeUpdate();
            fechar();
	    
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Competencia buscaPorCodigo(String codigo) {
	Competencia competencia = null;

        try {
            sql = "SELECT * FROM competencia WHERE codigo=?";
            conectar(sql);
            comando.setString(1, codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                competencia = new Competencia(
		    resultado.getString("nome"),
		    resultado.getString("codigo")
		);
            }
            fechar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return competencia;
    }

    @Override
    public List<Competencia> buscarPorNome(String nome) {
        List<Competencia> listaCompetencias = new ArrayList<>();

        try {
            sql = "SELECT * FROM competencia WHERE nome LIKE ?";
            conectar(sql);
            comando.setString(1, "%" + nome + "%");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Competencia competencia = new Competencia(
		    resultado.getString("codigo"),
		    resultado.getString("nome")
		);
		listaCompetencias.add(competencia);
            }
            fechar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (listaCompetencias);
    }

    @Override
    public List<Competencia> listar() {
	List<Competencia> listaCompetencias = new ArrayList<>();

        try {
            sql = "SELECT * FROM competencia";
            conectar(sql);
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Competencia competencia = new Competencia(
		    resultado.getString("codigo"),
		    resultado.getString("nome")
		);
                listaCompetencias.add(competencia);
            }
            fechar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaCompetencias;
    }
    
    private void conectar(String sql) throws ClassNotFoundException, SQLException {
        conexao = ConnectionFactory.getConnection();
        comando = conexao.prepareStatement(sql);
    }
    
    public void fechar() throws SQLException {
        comando.close();
        conexao.close();
    }
    
    /**
     * Método para pegar o id do funcionário por cpf
     * 
     * @param competencia
     * @return id
     */
    private int _pegaIdCompetenciaPorCodigo(Competencia competencia) {
	try {
	    sql = "SELECT id FROM competencia WHERE codigo = ?";
	    conectar(sql);
	    comando.setString(1, competencia.getCodigo());
	    ResultSet resultado = comando.executeQuery();
	    if (resultado.next()) {
		id = resultado.getInt("id");
	    }
	    fechar();
	} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CompetenciaDaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
	return id;
    }
    
    /**
     * Validação se já existe o código no banco de dados
     * 
     * @param codigo
     * @return true se codigo já existe | false se não existe
     */
    private boolean _validaCodigo(String codigo) {
	try {
	    sql = "SELECT codigo FROM competencia WHERE codigo = ?";
	    conectar(sql);
	    comando.setString(1, codigo);
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

}