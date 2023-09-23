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
   - TCP изисква потвърждаване на изпратената информация. И препраща изгубените пакети, ако има такива. 
   - Докато при UDP, ако пакетът е изгубен, той няма да поиска препредаване, а повредените данни ще бъдат получени от целевия компютър.
   - TCP е по-бавен в сравнение с UDP
6. Кой е първия програмист?
   - Ада Лъвлейс, която още през 1840 г. пише алгоритъм за изчисление чрез аналитична машина, призната в последствие за най-старата компютърна програма.

7. Каква е целат ама транспортния слой?
   - да транспортира пакетите с данни без грешки, в точна последователност и без загуби
8. Каква е ролята на IP протоколът?
   - той е отговорен за адресирането и фрагментацията на пакети данни в дигиталните мрежи
9. IPv4 и IPv6 - какво е новото и защо искаме IPv6?
   - IPv4 uses a 32-bit address while IPv6 uses a 128-bit address. 
   - This means that IPv6 offers 1,028 times more addresses than IPv4, 
   - which essentially solves the “running out of addresses” problem (at least for the foreseeable future)
10. IPv4 класове срещу CIDR. Какво е новото и защо се е наложило?
   - CIDR (Classless Inter-Domain Routing or supernetting) is a method of assigning IP addresses 
   - that improves the efficiency of address distribution and 
   - replaces the previous system based on Class A, Class B and Class C networks.
11. Какво е TTL в IP?
   - Time to live (TTL) refers to the amount of time or “hops” 
   - that a packet is set to exist inside a network before being discarded by a router.
12. Какво е TCP/IP модел?
   - TCP/IP is a data link protocol used on the internet to let computers and other devices send and receive data. 