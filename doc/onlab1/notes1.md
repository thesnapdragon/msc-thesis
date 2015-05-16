# MSc Önlab1

## Start

* Üdvözlök mindenkit, én Unicsovics Milán vagyok és most az MSc Önlab témámról fogok beszélni, melynek címe Tesztgenerálás állapotgép alapú modellekből.
* Röviden a legfontosabb címszavak; irodalomkutatás eredményei; demonstrációs szoftver; eredmények és értékelés

## Címszavak

* célja a hibadetektálás, melynek során az elvárt és aktuális működést összehasonlítjuk
* MBT során viselkedési modellekkel írjuk le a rendszert -> tesztesetek (bemenet és elvárt kimenet párok) = test suite -> tesztek futtatása a szoftveren

## Irodalomkutatás (1)

* bevezetés
* alapfogalmak ismertetése
* MBT folyamat bemutatása
* módszerek lehetséges osztályzása

## Irodalomkutatás (2)

* minél több eszköz bemutatása és összehasonlítása illetve ezek szempontjai
* teszteszközökhöz kapcsolódó fogalmak
* tanulságok levonása

## Irodalomkutatás (3)

* gráfelmélet és MBT kapcsolata + algoritmusok
* Chinese Postman: ha egy irányítatlan gráfban nincs Euler kör, melyik az a bejárás, ahol a legkevesebbszer kell újra bejárni éleket
* New York Street Sweeper: irányított gráfra
* teljes teszt lefedettséget adnak az előző algoritmusok, de nem generálják minden élpár kombináció tesztelését
* de Bruijn szekvencia -> értékpár alapú lefedettség
* véletlen bejárás vezérlése Markov láncokkal

## PyModel és GraphWalker

* milyen technológiákat használnak, hogyan épülnek fel?
* mire képesek?
* hogyan kell használni őket?
* példaalkalmazások készítése

## Tesztegeneráló könyvtár készítése

* 2 algoritmus
* G' = páratlan fokú csúcsokból teljes gráf -> élek súlya minimális súlyú utak
* G'' = maximális teljes párosítás G-ben
* árnyék élek hozzáadása G-hez G''-ból
* Euler kör G-ben

## System Under Test (SUT)

* stopper óra alkalmazás

## Teszt adapter és szkript

* minden él egy metódushívás

## Értékelés

* MBT háttér irodalomkutatás során
* módszerek egy részét kipróbálása
* MBT eszközök vizsgálata
* saját alkalmazáson kipróbáltam a tanultakat