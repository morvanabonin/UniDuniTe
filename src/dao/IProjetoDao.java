package dao;

import java.util.List;
import model.Projeto;

/**
 * Interface Dao de Projeto
 * 
 * @author morvanabonin
 */
public interface IProjetoDao {
    
    public void inserir(Projeto projeto) throws Exception;
    public void deletar(Projeto projeto);
    public void atualizar(Projeto projeto);
    public List<Projeto> listar();
    
}
