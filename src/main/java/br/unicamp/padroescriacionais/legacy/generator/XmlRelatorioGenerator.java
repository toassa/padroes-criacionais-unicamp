package br.unicamp.padroescriacionais.legacy.generator;

import br.unicamp.padroescriacionais.legacy.domain.Relatorio;

public class XmlRelatorioGenerator implements RelatorioGenerator {

    @Override
    public String gerar(Relatorio relatorio) {
        StringBuilder sb = new StringBuilder();
        sb.append("<relatorio>\n");
        sb.append("  <titulo>").append(escape(relatorio.getTitulo())).append("</titulo>\n");
        sb.append("  <tipo>").append(relatorio.getTipo().name()).append("</tipo>\n");
        sb.append("  <dataGeracao>").append(relatorio.getDataGeracao()).append("</dataGeracao>\n");
        sb.append("  <conteudo>").append(escape(relatorio.getConteudo())).append("</conteudo>\n");
        sb.append("</relatorio>\n");
        return sb.toString();
    }

    private String escape(String v) {
        if (v == null) return "";
        return v.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}
