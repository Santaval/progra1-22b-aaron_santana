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
TEST_IN = $(TEST_PATH)/input
TEST_OUT = $(TEST_PATH)/output
TEST_PREV = $(TEST_PATH)/input/gen_test.txt
input_files_amount =


#Linting
JAVA_LINT = linter.jar
INPUT_FILE = $(file)
# commands 

## linting

lint: google_lint sun_lint
	

google_lint: 
	@cat $(CONSOLE_TXT)/google_lint.txt	
	@$(JS) -jar $(JAVA_LINT) -c /google_checks.xml $(wildcard $(SRC_PATH))/*.java

sun_lint:
	@cat $(CONSOLE_TXT)/sun_lint.txt	
	@$(JS) -jar $(JAVA_LINT) -c /sun_checks.xml $(wildcard $(SRC_PATH))/*.java


## run app


run: compile execute
	 
compile: 
	@$(JC) $(JFLAGS) $(wildcard $(SRC_PATH))/*.java  $< -d $(OBJ_PATH)

gen_test: 
	@$(PY) $(MAIN_TEST_FL) > $(TEST_IN)

execute:
#@cat $(CONSOLE_TXT)/Title.txt

ifeq ($(INPUT_FILE), )
	@$(JS)  -classpath $(OBJ_PATH) $(OBJS)
else
	@$(JS) -classpath $(OBJ_PATH) $(OBJS) < $(INPUT_FILE)
endif	


bin: compile
	cd build
	jar -cfe Game.jar Game *
	mkdir bin/
	mv Game.jar ./ ../bin



doc: 
	javadoc -d doc/ src/*.java
	


test: compile bin 
	mkdir testout/
	java -jar bin/Game.jar < $(TEST_IN)/input001.txt > testout/output001.txt
	diff $(TEST_OUT)/output001.txt testout/output001.txt




clean: 
	rm -rf build bin doc testout