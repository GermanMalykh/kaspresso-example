#!/usr/bin/env bash
./gradlew connectedCheck
EXIT=$?
adb pull "/sdcard/Documents/allure-results" ./allure-results || true
exit $EXIT
