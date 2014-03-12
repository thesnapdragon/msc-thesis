# GraphWalker

* [hivatalos honlap](http://graphwalker.org/)

* online és offline tesztek is
* FSM-ből és EFSM-ből tud teszteket generálni

# Felhasznált technológiák

* Java
* Maven, tesztek futtatásához
* TestNG, tesztesetek leírásához
* Selenium, böngészővel való interakcióhoz (opcionális)
* yEd, modelltervezés, diagram generálás

# Munkafolyamat

1. tervezés
    * yEd segítségével tesztmodell előállítása => GraphML
    * stub generálás
    * tesztmodell kitöltése
2. tesztkód írása modellhez
3. tesztesetek futtatása

# Útvonal generálása

* A* útvonalkeresés
* legrövidebb út
* véletlenszerű bejárás
* minden permutáció

# Leállási kritériumok

* csúcs alapú lefedettség
* él alapú lefedettség
* követelmény alapú lefedettség
* csúcs elérése a gráfban
* él elérése a gráfban
* követelmény teljesítése
* időkorlát alapú
* soha

# Teszt futtatáshoz

*GraphWalker package készítés:

~~~ {.bash}
mvn package -DskipTests
~~~

* GraphWalker Examples teszt futtatáshoz:

~~~ {.bash}
mvn install:install-file -Dfile=<path_to_jar>/graphwalker-2.6.3-SNAPSHOT.jar -DgroupId=org.graphwalker -DartifactId=graphwalker -Dversion=2.6.3-SNAPSHOT -Dpackaging=jar
mvn test
~~~
