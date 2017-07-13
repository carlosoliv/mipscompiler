/*
 * Generated by classgen, version 1.5
 * 7/12/17 11:45 AM
 */
package ast;

public class Seq implements SyntaxNode {

  private SyntaxNode parent;
  public Seq seq;
  public E e;

  public Seq (Seq seq, E e) {
    this.seq = seq;
    if (seq != null) seq.setParent(this);
    this.e = e;
    if (e != null) e.setParent(this);
  }

  public SyntaxNode getParent() {
    return parent;
  }

  public void setParent(SyntaxNode parent) {
    this.parent = parent;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (seq != null) seq.accept(visitor);
    if (e != null) e.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (seq != null) seq.traverseTopDown(visitor);
    if (e != null) e.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (seq != null) seq.traverseBottomUp(visitor);
    if (e != null) e.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString() {
    return toString("");
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("Seq(\n");
      if (seq != null)
        buffer.append(seq.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
      if (e != null)
        buffer.append(e.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [Seq]");
    return buffer.toString();
  }
}
