package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.FormatoRelatorio;

public class RelatorioGeneratorFactory {

    public static RelatorioGenerator criar(FormatoRelatorio formato) {
        switch (formato) {
            case PDF:
                return new PdfRelatorioGenerator();
            case CSV:
                return new CsvRelatorioGenerator();
            case JSON:
                return new JsonRelatorioGenerator();
            case XML:
                return new XmlRelatorioGenerator();
            case HTML:
                return new HtmlRelatorioGenerator();
            default:
                throw new IllegalArgumentException("Formato nao suportado: " + formato);
        }
    }
}
