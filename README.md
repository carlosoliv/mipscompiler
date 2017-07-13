UNIVERSIDADE FEDERAL FLUMINENSE
CIENCIA DA COMPUTAÇÃO
COMPILADORES 2017.1

Aluno: Carlos de Oliveira
Professor: Luis Antonio Kowada

Compilador para MIPS

Instruções de uso:
------------------

Para usar o compilador, é preciso primeiro compilar ele.
Para isso, basta entrar nesta pasta pelo terminal e digitar o comando 'make'.

Esse comando criará o scanner, o parser, as classes da AST e finalmente compilará o compilador pra MIPS.

Voce também pode executar essas etapas separadamente, utilizando os seguintes comandos:
'make jflex': cria o scanner;
'make cup': cria o parser;
'make ast' cria as classes da AST;
'make compile': compila tudo, salvando na pasta 'bin'

Para rodar o compilador, basta rodar 'make run'.
Observe que no arquivo 'Makefile', no target 'run' está descrito o arquivo 'codigo.txt', que é o
código fonte que o compilador ira ler para compilar.

Caso queira limpar o projeto, voce pode usar o comando 'make clean' para apagar os binarios criados.
