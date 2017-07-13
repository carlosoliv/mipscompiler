all: jflex cup ast compile

jflex:
	java -jar tools/JFlex.jar src/compilador/Scanner.jflex -d src/compilador/

cup:
	java -jar tools/java-cup-11a.jar -destdir src/compilador/ -interface -parser Parser src/compilador/Parser.cup

ast:
	java -jar tools/classgen.jar -f -visitor -public -d src/compilador/ src/compilador/ast.cl

compile:
	mkdir -p bin
	javac -cp tools/java-cup-11a-runtime.jar:. -d bin src/compilador/*.java src/compilador/ast/*.java

clean:
	rm -rf src/Scanner.java src/Parser.java src/sym.java src/compilador/ast/ bin/*
	find . -type f -name "*.class" -exec rm -f {} \;

run:
	java -cp tools/java-cup-11a-runtime.jar:bin:. compilador.Main codigo.txt
