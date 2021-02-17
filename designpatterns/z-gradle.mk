designpatternsGradleName ?= designpatterns

designpatternsTasks:
	./gradlew :$(designpatternsGradleName):tasks

designpatternsTasksAll:
	./gradlew :$(designpatternsGradleName):tasks --all

designpatternsClean:
	./gradlew :$(designpatternsGradleName):clean

designpatternsDependencies:
	./gradlew :$(designpatternsGradleName):dependencies

designpatternsDependDefault:
	./gradlew :$(designpatternsGradleName):dependencies --configuration default

designpatternsDependCompileClasspath:
	./gradlew :$(designpatternsGradleName):dependencies --configuration compileClasspath

designpatternsDependentComponents:
	./gradlew :$(designpatternsGradleName):dependentComponents

designpatternsTest:
	./gradlew :$(designpatternsGradleName):test

designpatternsTestInfo: designpatternsClean
	@./gradlew :$(designpatternsGradleName):test --info

designpatternsJacocoTestReport:
	./gradlew :$(designpatternsGradleName):jacocoTestReport

designpatternsPiTest:
	./gradlew :$(designpatternsGradleName):pitest

help-designpatterns-gradle:
	@echo "=> $(designpatternsGradleName)/z-gradle.mk : gradle $(designpatternsGradleName) task"
	@echo "make designpatternsTasks                  -> show task of $(designpatternsGradleName)"
	@echo "make designpatternsTasksAll               -> show all task of $(designpatternsGradleName)"
	@echo "make designpatternsDependencies           -> $(designpatternsGradleName) full dependencies"
	@echo "make designpatternsDependDefault          -> $(designpatternsGradleName) dependencies of default"
	@echo "make designpatternsDependCompileClasspath -> $(designpatternsGradleName) dependencies of compileClasspath"
	@echo "make designpatternsDependentComponents    -> $(designpatternsGradleName) dependentComponents"
	@echo "make designpatternsClean                  -> $(designpatternsGradleName) clean"
	@echo "make designpatternsTest                   -> $(designpatternsGradleName) test case"
	@echo "make designpatternsJacocoTestReport       -> $(designpatternsGradleName) test jacocoTestReport"
	@echo "make designpatternsPiTest                 -> $(designpatternsGradleName) pitest"
	@echo ""