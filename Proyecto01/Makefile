# Java Makefile version 1.0.0 Nov-19-2022 Aaron Santana Valdelomar 

#java compiler
JC = javac 
JFLAGS = -g

#java start
JS = java

# Project objects
OBJS = Game Cell Figure GameBoard  



# Directoties 
BIN_PATH = bin
OBJ_PATH = build
SRC_PATH = src
MAIN_FILE = Game.java 

# commands 


run: compile
	@$(JS) $(run) -classpath $(OBJ_PATH) $(OBJS)
	 
compile: 
	@$(JC) $(JFLAGS) $(wildcard $(SRC_PATH))/*.java  $< -d $(OBJ_PATH)
	