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
JAR_OUT = jar_out

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


bin: clean compile
	@mv Makefile build
	@mkdir bin
	@$(MAKE) -C build gen_jar
	
	

gen_jar: 
	@jar cfe Game.jar Game *
	@mv Game.jar ../bin
	@mv Makefile ../


doc: 
	@javadoc -d doc/ src/*.java


##testing 	
	
test: 
	@python3 Test/src/MakeTest.py


	








clean: 
	rm -rf build bin doc testout jar_out