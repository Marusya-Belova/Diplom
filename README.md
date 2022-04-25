## Документация
1. [План автоматизации тестирования]( https://github.com/Marusya-Belova/Diplom/blob/77a09504225e1d1ea8e3a9e47c90b65fbec9e016/documents/Plan.md)
2. [Отчет по итогам тестирования](https://github.com/Marusya-Belova/Diplom/blob/b6bd73a6c8623444e45522b62f6171fd2afb064f/documents/Report.md)
3. [Отчет по итогам автоматизации тестирования](https://github.com/Marusya-Belova/Diplom/blob/b6bd73a6c8623444e45522b62f6171fd2afb064f/documents/Summary.md)

## Процедура установки, настройки и запуска ПО
### Перед запуском авто-тестов, необходимо:
Предусловия:
* Уcтановить среду разработки "Intellij IDEA Ultimate", "Docker";

* склонировать [репозиторий]( https://github.com/Marusya-Belova/Diplom.git)  командой 'git clone'

* Запустить контейнеры "MySQL", "PostgreSQL", "Node-app" в "Docker-compose";

* Запустить SUT для "MySQL" или "PostgreSQL".

**1. Для запуска контейнеров "MySQL", "PostgreSQL", "Node-app", в фоновом режиме, необходимо ввести в терминал следующую команду:**  
`docker-compose up -d`

**2.1 Для запуска SUT с "MySQL",  необходимо ввести в терминал следующую команду:**  
`java -Dspring.datasource.url=jdbc:mysql://localhost:3306/app -jar artifacts/aqa-shop.jar`  


**2.2 Для запуска SUT с "PostgreSQL",  необходимо ввести в терминал следующую команду:**
`java -Dspring.datasource.url=jdbc:postgresql://localhost:5432/postgres -jar artifacts/aqa-shop.jar`  

**3.1 Для запуска авто-тестов с "MySQL",  необходимо открыть новую вкладку терминала и ввести следующую команду:**

`./gradlew clean test -Ddb.url=jdbc:mysql://localhost:3306/app`

**3.2 Для запуска авто-тестов с "PostgreSQL",  необходимо открыть новую вкладку терминала и ввести следующую команду:**

`./gradlew clean test -Ddb.url=jdbc:postgresql://localhost:5432/postgres`

**4. Для запуска и просмотра отчета по результатам тестирования, с помощью "Allure", выполнить команду:**

`./gradlew allureReport`, затем `./gradlew allureServe`

**5. Для остановки работы контейнеров "Docker-Compose", необходимо ввести в терминал следующую команду:**  
`docker-compose down`
