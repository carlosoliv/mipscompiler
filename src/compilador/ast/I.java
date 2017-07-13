/*
 * Generated by classgen, version 1.5
 * 7/12/17 11:45 AM
 */
package ast;

public class I extends Block {

  public Def d;
  public I i;

  public I (Def d, I i) {
    this.d = d;
    if (d != null) d.setParent(this);
    this.i = i;
    if (i != null) i.setParent(this);
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
    if (d != null) d.accept(visitor);
    if (i != null) i.accept(visitor);
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
    if (d != null) d.traverseTopDown(visitor);
    if (i != null) i.traverseTopDown(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    if (d != null) d.traverseBottomUp(visitor);
    if (i != null) i.traverseBottomUp(visitor);
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("I(\n");
      if (d != null)
        buffer.append(d.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
      if (i != null)
        buffer.append(i.toString("  "+tab));
      else
        buffer.append(tab+"  null");
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [I]");
    return buffer.toString();
  }
}