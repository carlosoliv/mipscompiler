package compilador;

import ast.*;
import java.util.ArrayList;
import java.util.List;

public class FuncRepetidaVisitor extends VisitorAdaptor {

    private Block block;
    private List<String> listaFuncoes, listaVariaveis;
    private int ocorrenciasFuncoes = 0;
    private int ocorrenciasVariaveis = 0;

    public FuncRepetidaVisitor(Block block) {
        this.block = block;
        listaFuncoes = new ArrayList<String>();
        listaVariaveis = new ArrayList<String>();
    }
    
    @Override
    public void visit (Block block) {
        block.traverseTopDown(this);
    }

    @Override
    public void visit(Asm asm) {
        
        System.out.println("Pesquisando por variaveis repetidas: "+asm.id);
        
        if (listaVariaveis.size() == 0) listaVariaveis.add(asm.id);
        
        for (int i=0; i < listaVariaveis.size(); i++) {
            if (listaVariaveis.get(i).compareTo(asm.id) == 0) ocorrenciasVariaveis++;
        }
        
        if (ocorrenciasVariaveis > 1) {
            System.out.println("Mais de uma ocorrencia da variavel '"+asm.id+"'!");
            System.exit(1);
        } else {
            listaVariaveis.add(asm.id);
        }
    }

    @Override
    public void visit(Def def) {
        
        System.out.println("Pesquisando por funcoes repetidas: "+def.id);
        
        if (listaFuncoes.size() == 0) listaFuncoes.add(def.id);
        
        for (int i=0; i < listaFuncoes.size(); i++) {
            if (listaFuncoes.get(i).compareTo(def.id) == 0) ocorrenciasFuncoes++;
        }
        
        if (ocorrenciasFuncoes > 1) {
            System.out.println("Mais de uma ocorrencia da funcao '"+def.id+"'!");
            System.exit(1);
        } else {
            listaFuncoes.add(def.id);
        }
    }
}
