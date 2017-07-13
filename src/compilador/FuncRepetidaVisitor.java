package compilador;

import ast.Block;
import ast.Def;
import ast.VisitorAdaptor;
import java.util.ArrayList;
import java.util.List;

// d) não há funções declaradas mais de uma vez.
public class FuncRepetidaVisitor extends VisitorAdaptor {

    private List<String> listaFuncoes = new ArrayList<String>();
    private int ocorrenciasFuncoes = 0;

    public FuncRepetidaVisitor() {
    }
    
    @Override
    public void visit (Block block) {
        block.traverseTopDown(this);
    }

    @Override
    public void visit(Def def) {
        
        if (listaFuncoes.size() == 0) listaFuncoes.add(def.id);
        
        for (int i=0; i < listaFuncoes.size(); i++) {
            if (listaFuncoes.get(i).compareTo(def.id) == 0) ocorrenciasFuncoes++;
        }
        
        if (ocorrenciasFuncoes > 1) {
            System.out.println("Erro semantico mais de uma declaracao da funcao '"+def.id+"'!");
            System.exit(1);
        } else {
            listaFuncoes.add(def.id);
        }
    }
}
