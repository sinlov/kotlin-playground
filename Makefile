.PHONY: .gradle check build dist all

TOP_DIR := $(shell pwd)

# ifeq ($(FILE), $(wildcard $(FILE)))
# 	@ echo target file not found
# endif

include z-gradle-base.mk
include dashboard/z-gradle.mk
include designpatterns/z-gradle.mk

.PHONY: help
help: helpGradleBase help-dashboard-gradle help-designpatterns-gradle
	@echo "more task see makefile!"
