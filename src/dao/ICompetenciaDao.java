package dao;

import java.util.List;
import model.Competencia;

/**
 * Interface Dao de Competência
 *
 * @author morvanabonin
 */
public interface ICompetenciaDao {
    
    public void inserir(Competencia competencia);
    public void deletar(Competencia competencia);
    public void atualizar(Competencia competencia);
    public Competencia buscaPorId(int id);
    public List<Competencia> buscarPorNome(String nome);
    public List<Competencia> listar();

}
