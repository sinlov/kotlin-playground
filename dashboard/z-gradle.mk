dashboardGradleName ?= dashboard

dashboardTasks:
	${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):tasks

dashboardTasksAll:
	${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):tasks --all

dashboardClean:
	${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):clean

dashboardDependencies:
	${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):dependencies

dashboardDependDefault:
	${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):dependencies --configuration default

dashboardDependCompileClasspath:
	${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):dependencies --configuration compileClasspath

dashboardDependentComponents:
	${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):dependentComponents

dashboardTest:
	${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):test

dashboardTestInfo: dashboardClean
	@${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):test --info

dashboardJacocoTestReport:
	${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):jacocoTestReport

dashboardPiTest:
	${ENV_GRADLE_WRAPPER_EXEC} :$(dashboardGradleName):pitest

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