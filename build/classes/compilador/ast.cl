package ast;

Block ::= {Asm} String:id "NumberExp":val "Block":block
		| {I} "Def":d "I":i
		| {Def} String:id "Args":listargs "E":e

Args ::= String:id "Args":args

Seq ::= "Seq":seq "E":e

E ::= {NumberExp} Integer:val
		| {Ident} "String":nome
		| {IfThenElse} "E":e1 String:oprel "E":e2 "E":thenStr "E":elseStr
		| {OpArit} "E":e1 String:oparit "E":e2
		| {Decla} String:id "Seq":seq
