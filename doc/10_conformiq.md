# Conformiq

## Érvek MBT mellett:

* jobb hibadetektálás -> jobb minőség:
    * inkorrekt tesztesetek könnyen felfedezhetőek
    * modell alapján nincsenek kihagyott tesztesetek
    * nincsenek redundáns tesztek
* megismételhető, szisztematikus
* könnyebb karbantarthatóság -> kisebb költség, kevesebb idő; követhetőség - konzisztencia

## Támogatott modellezők:

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
2. (modell)
3. teszt generálás
    3.1. teszt lefedettség
    3.2. követhetőségi mátrix
4. [tesztesetek]
5. teszt exportálás: absztrakt tesztesetekből konkrét tesztesetek (*scripting backend*)
6. (teszt szkriptek)
7. teszt adapter
8. [teszt eredmény]

