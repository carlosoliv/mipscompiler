package compilador;

import java_cup.runtime.*;

%%
%public
%class Scanner
%cup
%implements sym
%line
%column

Ident = [a-zA-Z]+[_0-9a-zA-Z]*
Inteiro = 0|[1-9][0-9]*
white_space = [ \n\t\r\f]+

%%

<YYINITIAL> {
"if" 			{ System.out.println("Achei um if"); return new Symbol(IF, yyline, yycolumn); }
"then"			{ System.out.println("Achei um then"); return new Symbol(THEN, yyline, yycolumn); }
"else"			{ System.out.println("Achei um else"); return new Symbol(ELSE, yyline, yycolumn); }
"def"			{ System.out.println("Achei um def"); return new Symbol(DEF, yyline, yycolumn); }

{Ident}			{ System.out.println ("Achei um ident: "+yytext()); return new Symbol(IDENT, yyline, yycolumn, yytext()); }
{Inteiro}		{ System.out.println("Achei um int: "+yytext()); return new Symbol(INT, yyline, yycolumn, new Integer(Integer.parseInt(yytext()))); }

"+"				{ System.out.println ("Achei um +"); return new Symbol(PLUS, yyline, yycolumn); }
"-"				{ System.out.println ("Achei um -"); return new Symbol(MINUS, yyline, yycolumn); }
"*"				{ System.out.println ("Achei um *"); return new Symbol(TIMES, yyline, yycolumn); }
"/"				{ System.out.println ("Achei um /"); return new Symbol(DIV, yyline, yycolumn); }

"=="			{ System.out.println ("Achei um =="); return new Symbol(EQ, yyline, yycolumn); }
"="				{ System.out.println ("Achei um ="); return new Symbol(ASM, yyline, yycolumn); }
"<"				{ System.out.println ("Achei um <"); return new Symbol(LE, yyline, yycolumn); }
">"				{ System.out.println ("Achei um >"); return new Symbol(GR, yyline, yycolumn); }
";"		 		{ System.out.println ("Achei um ;"); return new Symbol(SEMI, yyline, yycolumn); }
","				{ System.out.println ("Achei um ,"); return new Symbol(COM, yyline, yycolumn); }
"."				{ System.out.println ("Achei um ."); return new Symbol(DOT, yyline, yycolumn); }
":"				{ System.out.println ("Achei um :"); return new Symbol(DDOT, yyline, yycolumn); }
"("				{ System.out.println ("Achei um ("); return new Symbol(LPAREN, yyline, yycolumn); }
")"				{ System.out.println ("Achei um )"); return new Symbol(RPAREN, yyline, yycolumn); }

{white_space}	{ /* ignore */ }

}

/* error fallback */

.|\n	{
			throw new RuntimeException("Entrada '"+yytext()+"' invalida! Linha: "+yyline+1+" Coluna: "+yycolumn+1);
		}
