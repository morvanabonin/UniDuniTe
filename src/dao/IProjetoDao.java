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
    public void deletar(int codigo);
    public void atualizar(int codigo, Projeto projeto);
    public List<Projeto> listar();
    public List<Projeto> listarProjetosAbertos();
    public List<Projeto> listarProjetosFechados();
    
}
