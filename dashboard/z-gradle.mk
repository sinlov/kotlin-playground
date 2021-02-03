dashboardGradleName ?= dashboard

dashboardTasks:
	./gradlew :$(dashboardGradleName):tasks

dashboardTasksAll:
	./gradlew :$(dashboardGradleName):tasks --all

dashboardClean:
	./gradlew :$(dashboardGradleName):clean

dashboardDependencies:
	./gradlew :$(dashboardGradleName):dependencies

dashboardDependDefault:
	./gradlew :$(dashboardGradleName):dependencies --configuration default

dashboardDependCompileClasspath:
	./gradlew :$(dashboardGradleName):dependencies --configuration compileClasspath

dashboardDependentComponents:
	./gradlew :$(dashboardGradleName):dependentComponents

dashboardTest:
	./gradlew :$(dashboardGradleName):test

dashboardTestInfo: dashboardClean
	@./gradlew :$(dashboardGradleName):test --info

dashboardJacocoTestReport:
	./gradlew :$(dashboardGradleName):jacocoTestReport

dashboardPiTest:
	./gradlew :$(dashboardGradleName):pitest

help-dashboard-gradle:
	@echo "=> $(dashboardGradleName)/z-gradle.mk : gradle $(dashboardGradleName) task"
	@echo "make dashboardTasks                  -> show task of $(dashboardGradleName)"
	@echo "make dashboardTasksAll               -> show all task of $(dashboardGradleName)"
	@echo "make dashboardDependencies           -> $(dashboardGradleName) full dependencies"
	@echo "make dashboardDependDefault          -> $(dashboardGradleName) dependencies of default"
	@echo "make dashboardDependCompileClasspath -> $(dashboardGradleName) dependencies of compileClasspath"
	@echo "make dashboardDependentComponents    -> $(dashboardGradleName) dependentComponents"
	@echo "make dashboardClean                  -> $(dashboardGradleName) clean"
	@echo "make dashboardTest                   -> $(dashboardGradleName) test case"
	@echo "make dashboardJacocoTestReport       -> $(dashboardGradleName) test jacocoTestReport"
	@echo "make dashboardPiTest                 -> $(dashboardGradleName) pitest"
	@echo ""