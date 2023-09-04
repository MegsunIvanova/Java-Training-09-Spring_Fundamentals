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