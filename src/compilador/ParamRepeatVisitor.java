package compilador;

import ast.Args;
import ast.Block;
import ast.VisitorAdaptor;
import java.util.ArrayList;
import java.util.List;

public class ParamRepeatVisitor extends VisitorAdaptor {

    private Block block;
    private List<String> listaArgs;
    private int ocorrenciasArgs = 0;

    public ParamRepeatVisitor(Block block) {
        this.block = block;
        listaArgs = new ArrayList<String>();
    }

    @Override
    public void visit(Block block) {
        block.traverseTopDown(this);
    }

    @Override
    public void visit(Args args) {
        System.out.println("Pesquisando por argumentos de funcoes repetidos: "+args.id);
        
        if (listaArgs.size() == 0) listaArgs.add(args.id);
        
        for (int i=0; i < listaArgs.size(); i++) {
            if (listaArgs.get(i).compareTo(args.id) == 0) ocorrenciasArgs++;
        }
        
        if (ocorrenciasArgs > 1) {
            System.out.println("Mais de uma ocorrencia da funcao '"+args.id+"'!");
            System.exit(1);
        } else {
            listaArgs.add(args.id);
        }
    }
}
