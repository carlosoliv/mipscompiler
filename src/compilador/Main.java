package compilador;

import java.io.FileReader;
import ast.Block;

public class Main {

    public static void main(String[] argv) throws Exception {

        String arquivo = "";
        if (argv.length == 0) {
            arquivo = "codigo.txt";
        } else {
            arquivo = argv[0];
        }

        System.out.println("Compilando codigo fonte '" + arquivo + "'...");

        // Fazendo o parsing
        Parser p = new Parser(new Scanner(new FileReader(arquivo)));
        Block result = (Block) p.parse().value;
        System.out.println("\nAST:\n" + result.toString());

        // Fazendo a analise semantica
        AnaliseSemantica analise = new AnaliseSemantica(result);
        analise.analisa();
        System.out.println("Passou em todas as analises semanticas!");
        
        /*
        // Fazendo a geracao de codigo MIPS
        GeraCodigo gerador = new GeraCodigo(result);
        gerador.gera();
        */
    }
}
