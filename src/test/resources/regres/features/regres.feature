#language: ru
@severity=critical
Функция: Тестирование API вебресурса https://reqres.in
    Сценарий: Успешное создание нового пользователя, сервер возвращает валидные данные
    Создаем нового пользователя отправкой POST запроса с измененными данными, прочитанных из файла,
    и проверяем валидность возвращенных данных

      Дано Подготовить тело запроса из ранее созданного файла, поменяв "name" и добавив поле "Job"
        |name|job|
        |Tomato|Eat maket|
      Затем Выполнить POST запрос на создание пользователя
      Тогда Проверить валидность возвращенных данных