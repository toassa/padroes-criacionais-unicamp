package br.unicamp.padroescriacionais.legacy;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGenerator;
import br.unicamp.padroescriacionais.legacy.generator.RelatorioGeneratorFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RelatorioGeneratorFactoryTest {

    @Test
    void deveCriarGeradorParaTodosFormatos() {
        for (FormatoRelatorio formato : FormatoRelatorio.values()) {

            RelatorioGenerator generator =
                    RelatorioGeneratorFactory.criar(formato);

            assertNotNull(generator, "Factory retornou null para: " + formato);

            assertTrue(
                generator.getClass()
                         .getSimpleName()
                         .toLowerCase()
                         .contains(formato.name().toLowerCase()),
                "Gerador incorreto para: " + formato
            );
        }
    }
}