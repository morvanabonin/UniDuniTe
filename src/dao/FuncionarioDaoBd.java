
package dao;

import banco.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funcionario;

/**
 * Classe de Crud de Funcionários 
 * implements da classe FuncionarioDao
 * 
 * @author morvanabonin
 */
public class FuncionarioDaoBd implements FuncionarioDao {
    
    private Connection conexao;
    PreparedStatement comando;
    
    
   /**
    * Método de inserção de um funcionário no bd
    * @param funcionario 
    */
    @Override
    public void inserir(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO funcionario(nome, cargo, cpf) VALUES (?, ?, ?)";
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
    
    /**
     * Método de deleção de um funcionário no bd
     * @param funcionario 
     */
    @Override
    public void deletar(Funcionario funcionario) {
        try {
            String sql = "DELETE FROM funcionario WHERE id=?";
            conectar(sql);
            comando.setInt(1, funcionario.getId());
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
        
    }

    /**
     * Método de busca de um funcionário por id
     * @param id
     * @return Funcionário funcionario;
     */
    @Override
    public Funcionario buscaPorId(int id) {
        return null;
    }
    
    /**
     * Método de busca de um funcionário por nome
     * @param nome
     * @return Funcionário funcionario;
     */
    @Override
    public List<Funcionario> buscarPorNome(String nome) {
        return null;
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
}
