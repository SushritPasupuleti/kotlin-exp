run:
	@read -p "Enter file name: " file; \
	echo "Compiling $$file"; \
	kotlinc $$file -include-runtime -d out.jar
	@echo "Compiled successfully"
	@java -jar out.jar
