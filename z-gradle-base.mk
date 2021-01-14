# init this project
init:
	./gradlew clean buildEnvironment

cleanRoot:
	./gradlew clean

# module module_shell_name
cleanGradleBuildAndIdea:
	./gradlew clean cleanBuildCache cleanIdea

cleanBuildCatch:
	@if [ -d ./.gradle ]; then rm -rf ./.gradle; fi
	@if [ -d ./buildCache ]; then rm -rf ./buildCache; fi
	@if [ -d ./buildCacheDir ]; then rm -rf ./buildCacheDir; fi
	@echo "clean .gradle buildCache buildCacheDir"

cleanAll: cleanGradleBuildAndIdea cleanBuildCatch
	@echo "clean all build !"

buildEnvironment:
	./gradlew buildEnvironment

helpGradleBase:
	@echo "=> z-gradle-base.mk : gradle base task"
	@echo "make init                    -> init this project for check base build error"
	@echo "make cleanRoot               -> run clean"
	@echo "make cleanGradleBuildAndIdea -> run clean cleanBuildCache cleanIdea"
	@echo "make cleanAll                -> run clean all"
	@echo ""