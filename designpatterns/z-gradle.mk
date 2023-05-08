designpatternsGradleName ?= designpatterns

designpatternsTasks:
	${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):tasks

designpatternsTasksAll:
	${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):tasks --all

designpatternsClean:
	${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):clean

designpatternsDependencies:
	${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):dependencies

designpatternsDependDefault:
	${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):dependencies --configuration default

designpatternsDependCompileClasspath:
	${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):dependencies --configuration compileClasspath

designpatternsDependentComponents:
	${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):dependentComponents

designpatternsTest:
	${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):test

designpatternsTestInfo: designpatternsClean
	@${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):test --info

designpatternsJacocoTestReport:
	${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):jacocoTestReport

designpatternsPiTest:
	${ENV_GRADLE_WRAPPER_EXEC} :$(designpatternsGradleName):pitest

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