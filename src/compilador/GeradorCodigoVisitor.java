package compilador;

import ast.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class GeradorCodigoVisitor extends VisitorAdaptor {

    private Block block;
    private PrintWriter printer;
    private String result = "";
    private List<String> listaRegis = new ArrayList<String>();
    private int funcs = 0;

    public GeradorCodigoVisitor(String arq) throws FileNotFoundException {
        printer = new PrintWriter(arq);
    }

    @Override
    public void visit(Block block) {
        block.traverseTopDown(this);

        printer.print(result);
        printer.close();
    }

    @Override
    public void visit(Asm asm) {
        //result += "Atribuicao: "+asm.id+"\n";
    }

    @Override
    public void visit(Ident ident) {
        result += "li $r" + listaRegis.size() + " " + ident.nome + "\n";
        listaRegis.add(ident.nome);
    }

    @Override
    public void visit(Def def) {
        Def no = new Def(def.id, def.listargs, def.e);

        result += no.id + "_entry:\n"
                + "\tmove $fp, $sp\n"
                + "\tsw $ra, 0($sp)\n"
                + "\taddiu $sp, $sp, -4\n";
        visit(no.e);
        result += "\tlw $ra, 4($sp)\n"
                + "\taddiu $sp, $sp " + (4 * numArgs(no)) + "\n"
                + "\tlw $fp, 0($sp)\n"
                + "\tjr $ra\n";
    }

    @Override
    public void visit(IfThenElse ifthen) {
        IfThenElse no = new IfThenElse(ifthen.e1, ifthen.oprel, ifthen.e2, ifthen.thenStr, ifthen.elseStr);

        visit(no.e1);
        result += "sw $a0, 0($sp)\n"
                + "addiu $sp, $sp, -4\n";
        visit(no.e2);

        if (no.oprel != null) {

            if (no.oprel.compareTo("==") == 0) {
                result += "lw $t1, 4($sp)\n"
                        + "addiu $sp, $sp, 4\n"
                        + "beq $a0, $t1, func_" + funcs + "_true\n"
                        + "func_" + funcs + "_false:\n";
            }
            if (no.oprel.compareTo(">") == 0) {
                result += "lw $t1, 4($sp)\n"
                        + "addiu $sp, $sp 4\n"
                        + "slt $t2, $a0, $t1\n"
                        + "beq $t2, 1, func_" + funcs + "_true\n"
                        + "func_" + funcs + "_false:\n";
            }
            if (no.oprel.compareTo("<") == 0) {
                result += "lw $t1, 4($sp)\n"
                        + "addiu $sp, $sp 4\n"
                        + "slt $t2, $t1, $a0\n"
                        + "beq $t2, 1, func_" + funcs + "_true\n"
                        + "func_" + funcs + "_false:\n";
            }
        }
        result += "\t";
        visit(no.thenStr);
        result += "\tb func" + funcs + "_end_if\n"
                + "func_" + funcs + "_true:\n";
        result += "\t";
        visit(no.elseStr);
        result += "func_" + funcs + "_end_if:\n";

        funcs++;
    }

    @Override
    public void visit(OpArit op) {
        OpArit no = new OpArit(op.e1, op.oparit, op.e2);

        visit(op.e1);
        result += "sw $a0, 0($sp)\n"
                + "addiu $sp, $sp - 4\n";
        visit(op.e2);

        if (no.oparit != null) {

            if (no.oparit.compareTo("+") == 0) {
                result += "lw $t1, 4($sp)\n"
                        + "add $a0, $t1, $a0\n"
                        + "addiu $sp, $sp, 4\n";
            }
            if (no.oparit.compareTo("-") == 0) {
                result += "lw $t1, 4($sp)\n"
                        + "sub $a0, $t1, $a0\n"
                        + "addiu $sp, $sp, 4\n";
            }
            if (no.oparit.compareTo("*") == 0) {
                result += "lw $t1, 4($sp)\n"
                        + "mult $a0, $t1\n"
                        + "mfhi $a0"
                        + "addiu $sp, $sp, 4\n";
            }
            if (no.oparit.compareTo("/") == 0) {
                result += "lw $t1, 4($sp)\n"
                        + "div $a0, $t1\n"
                        + "mflo $a0"
                        + "addiu $sp, $sp, 4\n";
            }
        }
    }

    public int numArgs(Def def) {
        Def no = new Def(def.id, def.listargs, def.e);
        int num = 0;

        while (no.listargs != null) {
            //System.out.println("Funcao: "+no.id+"; Arg: "+no.listargs.id);
            num++;
            no.listargs = no.listargs.args;
        }
        return num;
    }

}
