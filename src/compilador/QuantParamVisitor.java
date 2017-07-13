package compilador;

import ast.Block;
import ast.Asm;
import ast.Decla;
import ast.VisitorAdaptor;
import java.util.ArrayList;
import java.util.List;

// b) as funções chamadas foram definidas e com a quantidade de parâmetros compatível,
public class QuantParamVisitor extends VisitorAdaptor {
    private int numAsm = 0;

    @Override
    public void visit(Block block) {
        block.traverseTopDown(this);
    }
    
    @Override
    public void visit(Asm asm) {
        numAsm++;
    }
    
    @Override
    public void visit(Decla decla) {
        //System.out.println("Declaracao: "+decla.id);
        int numSeq = 0;
        
        
        // decla.seq pode ser null ()
        while (decla.seq != null) {
            numSeq++;
            decla.seq = decla.seq.seq;
            System.out.println("Declaracao: "+decla.id+"; numseq: "+numSeq);
        }
        
        
        if (numSeq != numAsm) {
            System.out.println("Erro semantico: funcao'" + decla.id + "' chamada com numero de parametros incompativel!");
            System.exit(1);
        }
        
        
    }

}
