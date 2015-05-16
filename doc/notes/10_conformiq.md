# Conformiq

## Linkek

* [Getting started1](https://www.youtube.com/watch?v=TV9CCyFeaLU)
* [Getting started2](https://www.youtube.com/watch?v=w3ap8ShGG_0)

## Érvek MBT mellett:

* jobb hibadetektálás -> jobb minőség:
    * inkorrekt tesztesetek könnyen felfedezhetőek
    * modell alapján nincsenek kihagyott tesztesetek
    * nincsenek redundáns tesztek
* megismételhető, szisztematikus
* könnyebb karbantarthatóság -> kisebb költség, kevesebb idő; követhetőség - konzisztencia

## Támogatott követelménymodellezők:

* IBM Rational
* Rhapsody
* Sparx Systems Enterprise
* ArchitectHP Quality Center
* IBM RequisitePro and
* DOORS

vagy a beépített Conformiq Modeler

* elérhetőség: Eclipse plugin / standalone

## Teszt automatizálása

1. manuális
2. record & playback: manuális tesztelés felvétele és újrajátszása
3. teszt szkriptek
4. automatizált tesztelés

## Típusok:

1. grafikus teszt modellezés: magát a tesztet grafikusan ábrázoljuk
2. környezet modellezése
3. rendszer modellezése

## Folyamat

1. [követelmények]
2. modellezés
  * rendszer blokkdiagrammja: külső interfész leírása (kimenő, bejövő portok)
  * UML statechart
  * Java szerű akcióleírás
3. teszt generálás
  3.1. teszt lefedettség
  3.2. követhetőségi mátrix
4. [tesztesetek]
5. teszt exportálás: absztrakt tesztesetekből konkrét tesztesetek (*scripting backend*)
6. (teszt szkriptek)
7. teszt adapter
8. [teszt eredmény]

## Implementing Conformiq Qtronic

* interfész tesztelése az implementációval szemben
* problémák:
  * túl nagy állapottér: nincs megoldás
  * leíró nyelv: UML statechart + blokkdiagram = QML
  * nem determinisztikus rendszerek
  * időzítés
  * köztes nyelv: LISP változat (CQλ)
* generálás: szimbolikus végrehajtás (kényszermegoldók segítségével)
* lefedettség vizsgálat (állapot, tranzíció): köztes nyelvből *checkpoint* metódus hívása modelltranszformációnál
