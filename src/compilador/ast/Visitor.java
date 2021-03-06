/*
 * Generated by classgen, version 1.5
 * 7/12/17 11:45 AM
 */
package ast;

public interface Visitor {

  public void visit(Args args);
  public void visit(Seq seq);
  public void visit(Block block);
  public void visit(Asm asm);
  public void visit(I i);
  public void visit(Def def);
  public void visit(E e);
  public void visit(NumberExp numberExp);
  public void visit(Ident ident);
  public void visit(IfThenElse ifThenElse);
  public void visit(OpArit opArit);
  public void visit(Decla decla);

}
