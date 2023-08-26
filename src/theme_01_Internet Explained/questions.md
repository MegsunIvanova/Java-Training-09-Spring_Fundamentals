# Лекция Internet Explained 

1. Какво е мрежови протокол?
   - система от стандартни правила за обмяната на информация в интернет
   - има 3 основни типа протоколи: протоколи за приложни програми (HTTP, FTP, SMTP  и др.), транспортни протоколи (TCP, UDP) и IP протокол
2. Какво е DNS?
   - Domain Name System -  система за имена в интернет, чрез която домейните се транслират в IP адреси
3. Какво e "turing complete" машина?
   - това е теоритично определение (machine that, given enough time and memory along with the necessary instructions, can solve any computational problem, no matter how complex)
4. Обяснете какво е OSI модела?
    - Open Systems Interconnection,  абстрактен модел, който описва начина на комуникация в компютърните мрежи
    - Състои се от 7 слоя, като всеки отговаря за определена част от комуникацията между потребителите
      Application Layer -> HTTPS, DNS, FTP, SMTP
      Presentation Layer -> TLS, SSL, compression
      Session Layer -> NetBios, PPTP, Sockets
      Transport Layer -> TCP, UDP
      Network Layer -> IP, IPsec
      Data Link Layer -> ATM, Ethernet, MAC, LLC
      Physical Layer -> USB, Bluetooth, 802.11a/b/g/n
5. Разлики между TCP и UDP?
   - TCP изисква потвърждаване на изпратената информация. И препраща изгубените пакети, ако има такива. Докато пти UDP, ако пакетът е изгубен, той няма да поиска препредаване, а повредените данни ще бъдат получени от целевия компютър.
   - TCP е по-бавен в сравнение с UDP   - 
6. Кой е първия програмист?
   - Ада Лъвлейс, която още през 1840 г. пише алгоритъм за изчисление чрез аналитична машина, призната в последствие за най-старата компютърна програма.