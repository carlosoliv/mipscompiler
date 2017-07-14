package compilador;

import ast.Block;
import java.io.FileNotFoundException;

public class GeraCodigo {

    private Block block;
    
    public GeraCodigo(Block block) {
        this.block = block;
    }

    public void gerar(String arq) throws FileNotFoundException {
        GeradorCodigoVisitor gerador = new GeradorCodigoVisitor(arq);
        gerador.visit(block);
    }

}
