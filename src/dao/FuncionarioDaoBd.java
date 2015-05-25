
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
import model.CPF;
import model.Funcionario;

/**
 * Classe de Crud de Funcionários 
 * implements da classe FuncionarioDao
 * 
 * @author morvanabonin
 */
public class FuncionarioDaoBd implements IFuncionarioDao {
    
    private Connection conexao;
    private PreparedStatement comando;
    private String sql;  
    private int id;
    
   /**
    * Método de inserção de um funcionário no bd
    * @param funcionario 
    */
    @Override
    public void inserir(Funcionario funcionario) {

	if (this._validaCpf(funcionario.getCpf())) {
	    try {
		throw new Exception("CPF já existe no Banco de Dados");
	    } catch (Exception ex) {
		Logger.getLogger(FuncionarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	    }
	} else {
	    try {
		sql = "INSERT INTO funcionario(nome, cargo, cpf) VALUES (?, ?, ?)";
		conectar(sql);
		comando.setString(1, funcionario.getNome());
		comando.setString(2, funcionario.getCargo());
		comando.setString(3, funcionario.getCpf());
		comando.executeUpdate();
		fechar();

	    } catch (ClassNotFoundException | SQLException ex) {
		Logger.getLogger(FuncionarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    /**
     * Método de deleção de um funcionário no bd
     * @param funcionario 
     */
    @Override
    public void deletar(Funcionario funcionario) {	
	id = this._pegaIdFuncionario(funcionario);
	try {
            sql = "DELETE FROM funcionario WHERE id=?";
	    conectar(sql);
	    comando.setInt(1, id);
	    comando.executeUpdate();
	    fechar();
	    
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Método de atualização de um funcionário no bd
     * @param funcionario 
     */
    @Override
    public void atualizar(Funcionario funcionario) {
	id = this._pegaIdFuncionario(funcionario);
        try {
	    sql = "UPDATE funcionario SET nome=?, cargo=?, cpf=? WHERE id=?";
            conectar(sql);
            comando.setString(1, funcionario.getNome());
            comando.setString(2, funcionario.getCargo());
	    comando.setString(3, funcionario.getCpf());
	    comando.setInt(4, id);
            comando.executeUpdate();
            fechar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método de busca de um funcionário por id
     * @param cpf
     * @return Funcionário funcionario;
     */
    @Override
    public Funcionario buscaPorCpf(String cpf) {
	Funcionario funcionario = null;

        try {
            sql = "SELECT * FROM funcionario WHERE cpf=?";
            conectar(sql);
            comando.setString(1, cpf);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()) {
                funcionario = new Funcionario(
		    resultado.getString("nome"),
		    resultado.getString("cargo"),
		    new CPF(resultado.getString("cpf"))
		);
            }
            fechar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return funcionario;
    }
    
    /**
     * Método de busca de um funcionário por nome
     * @param nome
     * @return Funcionário funcionario;
     */
    @Override
    public List<Funcionario> buscarPorNome(String nome) {
        List<Funcionario> listaFuncionarios = new ArrayList<>();

        try {
            sql = "SELECT * FROM funcionario WHERE nome LIKE ?";
            conectar(sql);
            comando.setString(1, "%" + nome + "%");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                Funcionario funcionario = new Funcionario(
			resultado.getString("nome"),
			resultado.getString("cargo"),
			new CPF(resultado.getString("cpf"))
		);
		listaFuncionarios.add(funcionario);
            }
            fechar();

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (listaFuncionarios);
    }
    
    /**
     * Método de busca de um funcionário por id 
     * @return lista de funcionario;
     */
    @Override
    public List<Funcionario> listar() {
        return null;
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
     * @param funcionario
     * @return id
     */
    private int _pegaIdFuncionario(Funcionario funcionario) {
	try {
	    sql = "SELECT id FROM funcionario WHERE cpf = ?";
	    conectar(sql);
	    comando.setString(1, funcionario.getCpf());
	    ResultSet resultado = comando.executeQuery();
	    if (resultado.next()) {
		id = resultado.getInt("id");
	    }
	    fechar();
	} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
	return id;
    }
    
    /**
     * Validação se já existe CPF no banco de dados
     * @param cpf
     * @return true se CPF já existe | false se não existe
     */
    private boolean _validaCpf(String cpf) {
	try {
	    sql = "SELECT cpf FROM funcionario WHERE cpf = ?";
	    conectar(sql);
	    comando.setString(1, cpf);
	    ResultSet resultado = comando.executeQuery();
	    if (resultado.next()) {
		return true;
	    }
	    fechar();
	} catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FuncionarioDaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
	return false;
    }
}
