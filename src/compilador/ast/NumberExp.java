/*
 * Generated by classgen, version 1.5
 * 7/12/17 11:45 AM
 */
package ast;

public class NumberExp extends E {

  public Integer val;

  public NumberExp (Integer val) {
    this.val = val;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);
  }

  public void childrenAccept(Visitor visitor) {
  }

  public void traverseTopDown(Visitor visitor) {
    accept(visitor);
  }

  public void traverseBottomUp(Visitor visitor) {
    accept(visitor);
  }

  public String toString(String tab) {
    StringBuffer buffer = new StringBuffer();
    buffer.append(tab);
    buffer.append("NumberExp(\n");
    buffer.append("  "+tab+val);
    buffer.append("\n");
    buffer.append(tab);
    buffer.append(") [NumberExp]");
    return buffer.toString();
  }
}