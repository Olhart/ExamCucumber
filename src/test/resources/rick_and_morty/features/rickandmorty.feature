#language: ru
@severity=minor
Функция: Тестирование API вебресурса rickandmortyapi.com
    Сценарий: Сравнение текущей локации и расы заданного персонажа с последним персонажем из последнего эпизода заданного персонажа
      Получаем персонажа (Морти) -> Получаем последный эпизод с Морти -> Получаем последнего персонажа в этом эпизоде -> Сраниваем его с Морти по расе и текущему местоположению

      Когда Отправили GET запрос и получили тело ответа с данными первого персонажа с ID 2
      И Отправили GET запрос и получили тело ответа с данными последнего персонажа из последнего эпизода с участием первого персонажа
      И Сравнили расу и название текущих местоположений двух персонажей