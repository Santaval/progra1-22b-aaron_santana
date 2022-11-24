# Java Makefile version 1.0.0 Nov-19-2022 Aaron Santana Valdelomar 

#java compiler
JC = javac 
JFLAGS = -g

#Pythin interpreter 
PY = Python3 

#java start
JS = java



# Project objects
OBJS = Game Cell Figure GameBoard  



# Directoties 
BIN_PATH = bin
OBJ_PATH = build
SRC_PATH = src
MAIN_FILE = Game.java 

#Testing 
TEST_PATH = test
MAIN_TEST_FL = $(TEST_PATH)/src/test.py
TEST_IN = $(TEST_PATH)/input/gen_test.txt
TEST_PREV = $(TEST_PATH)/input/input001.txt

# commands 

excecute: 
		@$(JS) $(run) -classpath $(OBJ_PATH) $(OBJS) < $(TEST_PREV)

run: compile gen_test
	@cat Title.txt
	@$(JS) $(run) -classpath $(OBJ_PATH) $(OBJS) < $(TEST_IN)
	 
compile: 
	@$(JC) $(JFLAGS) $(wildcard $(SRC_PATH))/*.java  $< -d $(OBJ_PATH)

gen_test: 
	@$(PY) $(MAIN_TEST_FL) > $(TEST_IN)

clean: 
	rm -rf build