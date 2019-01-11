import java.time.LocalDateTime;
import java.util.List;

public class Projeto {

    private String nome;
    private LocalDateTime dataInicio;
    private List<IntegranteProjeto> integranteList;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public List<IntegranteProjeto> getIntegranteList() {
        return integranteList;
    }

    public void setIntegranteList(List<IntegranteProjeto> integranteList) {
        this.integranteList = integranteList;
    }

    public void fazerDM() {
        this.integranteList
                .forEach(integranteProjeto -> integranteProjeto.fazerDM());
    }
}