#!/usr/bin/env zsh

./gradlew sortDependencies versionCatalogFormat ktlintFormat
./gradlew ktlintGenerateBaseline updateLintBaseline
./gradlew lint
# detektBaseline projectHealth
