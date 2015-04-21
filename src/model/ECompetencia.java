
package model;

/**
 * Enum de Competências
 * @author morvanabonin
 */
public enum ECompetencia {
    
    PHP, Java, JavaScript, MySQL, PostgreSQL, CSS, HTML, Ruby, Python;
    
    private String competencia;

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }
}
