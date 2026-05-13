package br.unicamp.padroescriacionais.legacy.domain;

public class ConfiguracaoSistema {

    private String nomeEmpresa;
    private String ambiente;
    private String diretorioExportacao;
    private boolean debugAtivo;

    // A. Atributo estático privado que armazenará a instância única
    private static ConfiguracaoSistema instancia;

    // B. Construtor alterado para PRIVATE
    // Isso impede que outras classes deem "new ConfiguracaoSistema(...)"
    private ConfiguracaoSistema() {
        // Valores padrão (podem ser alterados pelos setters depois)
        this.nomeEmpresa = "Empresa Legada";
        this.ambiente = "Produção";
        this.diretorioExportacao = "/outputs/reports";
        this.debugAtivo = false;
    }

    // C. Método estático público para acesso global à instância
    public static ConfiguracaoSistema getInstance() {
        if (instancia == null) {
            instancia = new ConfiguracaoSistema();
        }
        return instancia;
    }

    // Getters e Setters permanecem iguais para preservar o funcionamento existente
    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public String getDiretorioExportacao() {
        return diretorioExportacao;
    }

    public void setDiretorioExportacao(String diretorioExportacao) {
        this.diretorioExportacao = diretorioExportacao;
    }

    public boolean isDebugAtivo() {
        return debugAtivo;
    }

    public void setDebugAtivo(boolean debugAtivo) {
        this.debugAtivo = debugAtivo;
    }
}