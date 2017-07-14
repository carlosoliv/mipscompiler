package compilador;

import ast.Block;
import ast.Def;
import ast.Ident;
import ast.VisitorAdaptor;
import java.util.ArrayList;
import java.util.List;

// a) os identificadores que aparecem em cada função são passados como parâmetros
public class IdentComoParametrosVisitor extends VisitorAdaptor {

    private List<String> listaArgs = new ArrayList<String>();
    private String defAtual = "";

    @Override
    public void visit(Block block) {
        block.traverseTopDown(this);
    }

    @Override
    public void visit(Def def) {
        Def no = new Def(def.id, def.listargs, def.e);
        defAtual = no.id;

        while (no.listargs != null) {
            //System.out.println("Funcao: "+no.id+"; Arg: "+no.listargs.id);
            listaArgs.add(no.listargs.id);
            no.listargs = no.listargs.args;
        }
    }

    @Override
    public void visit(Ident ident) {
        //System.out.println("Def atual: " + defAtual + "; ident: " + ident.nome);
        int ocorrenciasArgs = 0;

        for (int i = 0; i < listaArgs.size(); i++) {
            if (listaArgs.get(i).compareTo(ident.nome) == 0) {
                ocorrenciasArgs++;
            }
        }
        if (ocorrenciasArgs == 0) {
            System.out.println("Erro semantico: identificador '"+ident.nome+"' nao reconhecido na funcao '"+defAtual+"'!");
            System.exit(1);
        }
    }
}
