#### Шаги для запуска тестов
1. Открыть проект
1. Выполнить в терминале команду 'docker-compose -f docker-compose.yml -p reportportal up -d --force-recreate --build' (объем загружаемых образов ~3Гб)
1. Запустить (java -jar ./artifact/app-card-delivery.jar)
1. Запустить тесты командой 'gradle clean test'
1. Отчеты будут доступны по адресу 'http://localhost:8080'

Стандартная учетная запись - default\1q2w3e