package compilador;

import ast.Block;
import java.util.List;

//"Provide new implementations of the Visitor interface for the various semantics checks."
public class AnaliseSemantica {

    private Block block;

    public AnaliseSemantica(Block block) {
        this.block = block;
    }

    public void analisa() {

        // a) os identificadores que aparecem em cada função são passados como parâmetros,
        //IdentComoParametrosVisitor identParam = new IdentComoParametrosVisitor();
        //identParam.visit(block);
        
        // b) as funções chamadas foram definidas e com a quantidade de parâmetros compatível,
        QuantParamVisitor quantParam = new QuantParamVisitor();
        //quantParam.visit(block);

        // c) não há parâmetros repetidos (na declaração de uma função),
        ParamRepeatVisitor paramRepeat = new ParamRepeatVisitor();
        paramRepeat.visit(block);

        // d) não há funções declaradas mais de uma vez.
        FuncRepetidaVisitor funcRep = new FuncRepetidaVisitor();
        funcRep.visit(block);

    }
}
