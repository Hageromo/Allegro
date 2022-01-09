# Getting Started

### Reference Documentation

* [Official GitHub documentation](https://docs.github.com/en/rest)


### List of endpoints to use testing my app

* [localhost:8080/repos/{User}]               returns name of every repository that user(owner of the github) has, number of stars in this repository.
* [localhost:8080/repos/{User}/stars]         returns sum of every star user's(owner of the github) got on GitHub.
* [localhost:8080/repos/{User}/repos]         returns languages used by user(owner of the github), and size of files in that specific language.


Aplikacja powinna działać bez bez podawania tokena przez kilkadziesiąt godzin.
Aby dodać swój token chcąc korzystać dłużej z github API możemy wygenerować go na stronie githuba a następnie w miejsce application.proper ustawić jego wartość (toke=).
Aby aplikacja zadziałała z naszym tokenem w klasie HttpGithubRepositoriesRepository odkometowywujemy zmienne oraz headery token w odpowiednich miejscach oraz w konstruktorze 
dodajemy @Value("${token}") String token.