package compilador;

import ast.Block;
import ast.VisitorAdaptor;

public class GeradorCodigoVisitor extends VisitorAdaptor {
    private Block block;

    public GeradorCodigoVisitor(Block block) {
        this.block = block;
    }
    
    @Override
    public void visit (Block block) {
        block.traverseTopDown(this);
    }
}
