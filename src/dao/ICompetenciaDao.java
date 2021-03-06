package dao;

import java.util.List;
import model.Competencia;

/**
 * Interface Dao de Competência
 *
 * @author morvanabonin
 */
public interface ICompetenciaDao {
    
    public void inserir(Competencia competencia) throws Exception;
    public void deletar(Competencia competencia);
    public void atualizar(Competencia competencia);
    public void atualizarPorId(int id, Competencia competencia);
    public Competencia buscaPorCodigo(String codigo);
    public List<Competencia> buscarPorNome(String nome);
    public List<Competencia> listar();

}
