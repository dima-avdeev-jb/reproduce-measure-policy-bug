#!/bin/bash
rm -rf build
rm -rf */build
./gradlew clean --no-daemon run
