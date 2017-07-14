package compilador;

import ast.Block;
import ast.Asm;
import ast.Decla;
import ast.VisitorAdaptor;

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
        Decla obj = new Decla (decla.id, decla.seq);
        int numSeq = 0;

        // decla.seq pode ser null ()
        while (obj.seq != null) {
            numSeq++;
            obj.seq = obj.seq.seq;
            //System.out.println("Declaracao: " + obj.id + "; numseq: " + numSeq);
        }

        if (numSeq != numAsm) {
            System.out.println("Erro semantico: funcao'" + obj.id + "' chamada com numero de parametros incompativel!");
            System.exit(1);
        }
    }
}
