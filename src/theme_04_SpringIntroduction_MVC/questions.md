# Лекция Spring MVC

1. Как анотираме контролер класовете си?
   - @Controller или @RestController
2. Как използване @RequestMapping анотацията?
   - върху клас левел или метод на контролера и трябва да се сложи метод на заявката
3. Има ли разлика между @GetMapping и @RequestMapping с метод Get върху метода?
   - не, няма
4. Как може да се вземе POST параметър?
   - с DTO или с @Request анотацията
5. Как предаваме обект към Thymeleaf view?
   -  с Model, ModelMap и ModelView
6. Как може да вземем optional параметър?
   - в анорацията @RequestParam има optional, която има ст-ст true или false
7. Как може да зададем default стойност на параметър?
   - @RequestParam може да се сложи default value
8. Каква е разликата между Path variable и Query parameter?
   - едното е в path на url-то, а другото в query

9. Какво е MVC?
   - един pattern: имаме един клас, който е контролер и той приема някакви команди, създава модел (нещо като HashMap) и накрая връща view  
10. Какво разбирате под "front-end controller"
   - класът, който приема всичките заявки, които идват към дадения web app
11. Какво е Dispatcher Servlet?
   - front-end controller - през него в Spring MVC преминават всичките заявки, в които има Handler (нашия контролер), който изпълнява заявките
12. Как можем да предадем атрибути към едно view?
    - инжектират се в модела - с име и стойност
13. Слоеве в типичен Spring Application?
   - контролери (web слой) -> обработват HTTP заявките
   - service layer -> бизнес логиката
   - repositories -> осъществяват достъп до обектите в базата данни
   - entities -> класове мапнати към обектите в базата, които са тио POJO
14. Как може да реализираме Get/Post и т.н. заявки в контролер?
   - с анотации @GetMapping и @PostMapping или @RequestMapping
15. Какво ще стабе ако пратим POST заявка към endpoint, който може да обработва само GET заявки?
   - Spring автоматично ще върне HTTP статус 405 