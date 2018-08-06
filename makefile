.PHONY: java clean

default: 
	@echo "Select a language as a target"

build.java: 
	@echo "Building java project"
	@javac java/*.java

run.java:
	@java -cp java ProjectEuler $(filter-out $@,$(MAKECMDGOALS))

run.go:
	@go run golang/*.go $(filter-out $@,$(MAKECMDGOALS))

clean:
	find . -type f -name '*.class' -delete

%:
	@: