# Java Makefile version 1.0.0 Nov-19-2022 Aaron Santana Valdelomar 

#java compiler
JC = javac 
JFLAGS = -g

#Pythin interpreter 
PY = python3 

#java start
JS = java



# Project objects
OBJS = Game Cell Figure GameBoard  



# Directoties 
BIN_PATH = bin
OBJ_PATH = build
SRC_PATH = src
MAIN_FILE = Game.java 
CONSOLE_TXT = console

#Testing 
TEST_PATH = Test
MAIN_TEST_FL = $(TEST_PATH)/src/Test.py
TEST_IN = $(TEST_PATH)/input/gen_test.txt
TEST_PREV = $(TEST_PATH)/input/gen_test.txt

#Linting
JAVA_LINT = linter.jar

# commands 


lint: 
	@cat $(CONSOLE_TXT)/google_lint.txt	
	@$(JS) -jar $(JAVA_LINT) -c /google_checks.xml $(wildcard $(SRC_PATH))/*.java

	
# @cat $(CONSOLE_TXT)/sun_lint.txt	
#@$(JS) -jar $(JAVA_LINT) -c /sun_checks.xml $(wildcard $(SRC_PATH))/*.java
	

execute: 
		@$(JS) $(run) -classpath $(OBJ_PATH) $(OBJS) < $(TEST_PREV)

run: compile gen_test
	@cat $(CONSOLE_TXT)/Title.txt
	@$(JS) $(run) -classpath $(OBJ_PATH) $(OBJS) < $(TEST_IN)
	 
compile: 
	@$(JC) $(JFLAGS) $(wildcard $(SRC_PATH))/*.java  $< -d $(OBJ_PATH)

gen_test: 
	@$(PY) $(MAIN_TEST_FL) > $(TEST_IN)

clean: 
	rm -rf build