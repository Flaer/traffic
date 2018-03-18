# REST сервис для учета трафика сайта

## Описание
Сервис поддерживает две команды
**/visit**  - POST запрос для регистрации посещения сайта пользователем.
Создает запись о визите и возвращает статистику посещений за текущие сутки в
JSON формате.

URL: `http://localhost:8080/visit`  
Body: `{"userId":"user","pageId":"about"}`  
Headers: `"Content-Type":"application/json"`  
Return example: `{"uniqueUsersAmount":2,"visitsAmount":15}`  

**/statistics** - GET запрос для вывода расширенной статистики за
произвольный период. Формат даты выбран ISO-8601 yyyy-mm-dd.
Внимание! даты считаются началом суток, т.е. 2018-03-21 будет
равна 21.03.2018 00:00:00.000, учитывайте это при тестировании.  
URL: `http://localhost:8080/statistics?start=2018-03-16&end=2018-03-21`  
Пример результата:  
`{"uniqueUsersAmount":2,"visitsAmount":15,"regularUsersAmount":1}`  

## Сборка
Из директории с pom.xml выполнить команду `mvn clean install`  
Во время сборки будут выполнены тесты.  
После сборки запустить приложение из target каталога командой  
`java -jar traffic-0.0.1-SNAPSHOT.jar`  
База данных будет создана автоматически и заполнена тестовыми данными
с текущим временем создания.  
Если положить базу traffic.mv.db рядом
с jar файлом, то будет использована она.  
Используется настройка spring.jpa.hibernate.ddl-auto=create-drop,
которая пересоздаст все таблицы перед запуском.

#### Просмотр консоли H2 базы данных  
`http://localhost:8080/console`  

Connection settings:  
JDBC  URL: jdbc:h2:file:./traffic  
User Name: sa  
Password: (empty)  
