package compilador;

import ast.Block;
import ast.Def;
import ast.VisitorAdaptor;
import java.util.ArrayList;
import java.util.List;

// c) não há parâmetros repetidos (na declaração de uma função)
public class ParamRepeatVisitor extends VisitorAdaptor {

    private List<String> listaArgs = new ArrayList<String>();

    public ParamRepeatVisitor() {
    }

    @Override
    public void visit(Block block) {
        block.traverseTopDown(this);
    }

    @Override
    public void visit(Def no) {

        while (no.listargs != null) {
            //System.out.println("Funcao: "+no.id+"; Arg: "+no.listargs.id);
    
            for (int i = 0; i < listaArgs.size(); i++) {
                if (listaArgs.get(i).compareTo(no.listargs.id) == 0) {
                    System.out.println("Erro semantico: mais de uma ocorrencia do argumento '" + no.listargs.id + "' na funcao '"+no.id+"'!");
                    System.exit(1);
                }
            }
            listaArgs.add(no.listargs.id);
            no.listargs = no.listargs.args;
        }
        
        // Cleaning the list for the next occurrence of the 'Def' node.
        listaArgs = new ArrayList<String>();
    }
}
