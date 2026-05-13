package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.ConfiguracaoSistema;
import br.unicamp.padroescriacionais.legacy.service.ConfiguracaoService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConfiguracaoSistemaTest {

    @Test
    void deveRetornarSempreAMesmaInstancia() {
        // Agora usamos o getInstance() em vez de 'new'
        ConfiguracaoSistema config1 = ConfiguracaoSistema.getInstance();
        ConfiguracaoSistema config2 = ConfiguracaoSistema.getInstance();

        // Verifica se ambas as variáveis apontam para o MESMO objeto na memória
        assertSame(config1, config2, "O Singleton deve garantir que a instância seja única.");
    }

    @Test
    void devePermitirAlteracaoDeAmbienteCentralizada() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setAmbiente("PROD");

        assertEquals("PROD", config.getAmbiente());
    }

    @Test
    void devePermitirAlteracaoDeDebugCentralizada() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setDebugAtivo(true);

        assertTrue(config.isDebugAtivo());
    }

    @Test
    void devePermitirAlteracaoDeDiretorioCentralizada() {
        ConfiguracaoSistema config = ConfiguracaoSistema.getInstance();
        config.setDiretorioExportacao("/novo/diretorio");

        assertEquals("/novo/diretorio", config.getDiretorioExportacao());
    }

    @Test
    void alteracaoEmUmaReferenciaDeveAfetarTodasAsOutras() {
        // Este teste substitui o antigo que testava instâncias independentes
        ConfiguracaoSistema ref1 = ConfiguracaoSistema.getInstance();
        ConfiguracaoSistema ref2 = ConfiguracaoSistema.getInstance();

        ref1.setAmbiente("STAGING");

        // Como é Singleton, se mudei na ref1, a ref2 TEM que refletir a mudança
        assertEquals("STAGING", ref2.getAmbiente(), "A alteração deve ser visível em todas as referências.");
    }

    @Test
    void configuracaoServiceDeveUsarInstanciaSingleton() {
        ConfiguracaoService service = new ConfiguracaoService();
        ConfiguracaoSistema configGlobal = ConfiguracaoSistema.getInstance();
        
        // Verifica se o Service está usando a mesma instância global
        assertSame(configGlobal, service.getConfiguracao(), "O Service deve usar o Singleton global.");
    }
}