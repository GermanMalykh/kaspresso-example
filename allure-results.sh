#!/usr/bin/env bash
./gradlew connectedCheck
EXIT=$?

# Подтягиваем Allure-результаты с устройства (несколько возможных путей)
mkdir -p allure-results
# Путь для API < 29 или при записи в Documents
adb pull "/sdcard/Documents/allure-results" ./allure-results-pull 2>/dev/null || true
# Путь приложения на API 29+ (getExternalFilesDir + allure-results)
adb pull "/sdcard/Android/data/com.example.kaspresso/files/allure-results" ./allure-results-app 2>/dev/null || true
# На случай если файлы лежат прямо в files/
adb pull "/sdcard/Android/data/com.example.kaspresso/files" ./allure-results-files 2>/dev/null || true

# Собираем все результаты в одну папку (json/txt — файлы Allure)
for dir in allure-results-pull allure-results-app; do
  if [ -d "$dir" ]; then
    cp -n "$dir"/* allure-results/ 2>/dev/null || true
    rm -rf "$dir"
  fi
done
if [ -d "allure-results-files" ]; then
  find allure-results-files -maxdepth 2 -type f \( -name '*-result.json' -o -name '*-attachment.*' \) -exec cp -n {} allure-results/ \;
  rm -rf allure-results-files
fi

exit $EXIT
