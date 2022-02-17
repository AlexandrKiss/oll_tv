# Тестовое задание ollTV
### Задача: вывод списка телепередач с подгрузкой данных с сервера.

Для получения данных нужно выполнить HTTP GET запрос к серверу следующего
вида:
http://oll.tv/demo?serial_number=&borderId=&direction=
- *serial_number* - уникальный идентификатор устройства (серийный номер, mac-адрес, drmid, uuid и т.д.), который нужно получить через API устройства
- *borderId* - идентификатор элемента, который является граничным в ответах сервера
- *direction* - направление листания(может принимать значения -1, 0 и 1)

Сервер возвращает данных в виде JSON, в котором:
- *items* - массив элементов, которые нужно выводить в списке
- *items_number* - количество элементов в массиве items
- *total* - общее количество элементов
- *offset* - количество элементов от начала списка до текущего borderId
- *hasMore* - количество элементов от borderId до конца списка

Элементы из массива items содержат поля:
- *id* - уникальный идентификатор записи (нужно подставлять в качестве значения borderId)
- *icon* - ссылка на логотип телеканала
- *name* - название телепередачи

При открытии приложения должен быть выполнен запроc c borderId = 0 и direction = 0, при
этом сервер вернет информацию о телепередачах, которые идут в текущий момент или
начнутся в ближайшее время. При листании необходимо брать id первого/последнего
элемента массива и подставлять в поле borderId в запросе к серверу, а direction = -1/1 в
зависимости от направления листания.

**Требования:**
1. Дать временную оценку (в часах) на выполнение задачи
2. Выполнить тестовое задание и предоставить доступ к исходному коду для ревью.
Код должен успешно компилироваться и собираться в приложение с помощью Android
Studio.

**Результат:**
- [x] Рабочая двухсторонняя пагинация.
- [x] В списке необходимо вывести логотип телеканала и название телепередачи в одну строку.
- [x] На время ожидания данных от сервера необходимо показывать лоадер.
- [x] При нажатии на элемент необходимо открыть информацию о телепередаче в новом окне с transition.

**Стэк:**
- Kotlin
- Material Design
- **MVVM**/MVP
- Dagger2/Koin/**Hilt**
- Retrofit
- Navigation
- Paging 3

*Эталонный пример работы - раздел “Программы” официального приложения oll.tv*