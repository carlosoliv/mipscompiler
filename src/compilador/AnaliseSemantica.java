package compilador;

import ast.*;
import java.util.List;

//"Provide new implementations of the Visitor interface for the various semantics checks."
public class AnaliseSemantica {

    private Block block;

    public AnaliseSemantica(Block block) {
        this.block = block;
    }

    public void analisa() {

        // a) os identificadores que aparecem em cada função são passados como parâmetros,
        //IdentComoParametrosVisitor identParam = new IdentComoParametrosVisitor(block);
        //identParam.visit(block);
        
        // b) as funções chamadas foram definidas e com a quantidade de parâmetros compatível,
        //QuantParamVisitor quantParam = new QuantParamVisitor(block);
        //quantParam.visit(block);

        // c) não há parâmetros repetidos (na declaração de uma função),
        ParamRepeatVisitor paramRepeat = new ParamRepeatVisitor(block);
        //paramRepeat.visit(block);

        // d) não há funções declaradas mais de uma vez.
        FuncRepetidaVisitor funcRep = new FuncRepetidaVisitor(block);
        funcRep.visit(block);

    }
}
