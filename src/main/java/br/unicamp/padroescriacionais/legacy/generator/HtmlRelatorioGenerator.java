package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class HtmlRelatorioGenerator implements RelatorioGenerator {

    @Override
    public String gerar(Relatorio relatorio) {
        StringBuilder sb = new StringBuilder();
        sb.append("<!doctype html>\n");
        sb.append("<html><head><meta charset=\"utf-8\"><title>").append(escape(relatorio.getTitulo())).append("</title></head><body>\n");
        sb.append("<h1>").append(escape(relatorio.getTitulo())).append("</h1>\n");
        sb.append("<p><strong>Tipo:</strong> ").append(relatorio.getTipo().name()).append("</p>\n");
        sb.append("<p><strong>Gerado em:</strong> ").append(relatorio.getDataGeracao()).append("</p>\n");
        sb.append("<pre>").append(escape(relatorio.getConteudo())).append("</pre>\n");
        sb.append("</body></html>\n");
        return sb.toString();
    }

    private String escape(String v) {
        if (v == null) return "";
        return v.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
