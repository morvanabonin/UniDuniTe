package dao;

import java.util.List;
import model.Funcionario;

/**
 * Interface Dao de Funcionário
 *
 * @author morvanabonin
 */
public interface IFuncionarioDao {
    
    public void inserir(Funcionario funcionario);
    public void deletar(Funcionario funcionario);
    public void atualizar(Funcionario funcionario);
    public Funcionario buscaPorCpf(String CPF);
    public List<Funcionario> buscarPorNome(String nome);
    public List<Funcionario> listar();

}
