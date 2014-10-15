# Broy, Manfred and Jonsson, Bengt and Katoen, Joost-Pieter and Leucker, Martin and Pretschner, Alexander: Model-Based Testing of Reactive Systems: Advanced Lectures

Tartalom:
1. véges állapotú automaták tesztelése
2. címkézett tranzíciós rendszerek tesztelése
3. modell alapú teszteset generálás
4. eszközök és esettanulmányok
5. szabványos jelölés a teszteléshez; futtatás
6. függelék

## 3. Modell alapú teszteset generálás

1. módszertanok áttekintése

* motiváció:
    * Miért nem egyből a SUT-ot teszteljük? A SUT modelljének előállítása egyszűbb, könnyebb megérteni, validálni, karbantartani és könnyebb új tesztesetek készíttetni vele.
    * kódgenerálás
* modell:
    * leképezés: konkrétról az absztrakt világra
    * szándék kifejezése
    * egyszerűsítés: absztrakcióval
        * részletek elhagyása vagy részletek egységbezárása
        * mivel a modell alapján származtatott bemenetek más absztrakciós szinten vannak, ezért egy adapterre van szükség, hogy a rendszernek bemenetként lehessen adni
* MBT alkalmazási scenario-k:
    * általános: egy modellt készítünk a specifikáció alapján, melyből a teszteseteket és a tesztelendő kódot is legeneráljuk
    * automatikus teszt kinyerés: a specifikáció alapján megírt kódból nyerjük ki a modellt, amelyből generáljuk a teszteseteket
    * manuális modellezés: a specifikáció alapján a kódot és a modellt is manuálisan készítjük
    * eltérő modellek: különböző modellje van a kódgenerálásnak és a tesztelésnek

2. bemenetek előállítása struktúrális (pl.: állapot/átmenet lefedettség), funkcionális vagy sztochasztikus kritériumok alapján
3. teszt generálási technológia: modell ellenőrző, tétel bizonyító, szimbolikus futtatás, logikai programozás
4. valós idejű és hibrid rendszerek tesztelése

## 6. Függelék

* tesztelési szándék / cél: azon tulajdonság, amit tesztelni kívánunk
* teszteset specifikáció: a tesztelési célok formális megadása, melyből test suite generálható
* teszteset generátor: teszteset specifikációból és a SUT-ból tesztesetek készítése
* tesztelés: tesztelési célok definiálása, teszteset specifikáció készítése, test suite generálás, teszt futtatás
* teszt végrehajtás / futtatás: tesztbemenetek SUT-nak, SUT monitorozása, elvárt kimenet összehasonlítása a valós kimenettel
* teszt rendszer: teszt motor, végrehajtható tesztek, adapterek
* verifikáció: "Jól készítjük a rendszert?", a specifikációnak megfelelő viselkedés ellenőrzése, tesztelés ide tartozik
* validáció: "Jó rendszert készítünk?", megfelel-e a követelményeknek a viselkedés
* megfelelőség: a SUT megfigyelhető viselkedése és a specifikáció vagy modell közötti kapcsolat
* monitor: a SUT azon részeinek megfigyelése, amelyre vonatkozik a teszteset
* ítélet / döntés: a megfigyelt viselkedés megegyezik-e az elvárttal? (pass / fail / inconclusive)
* Black-Box Testing: a SUT belső struktúrája nem ismert
* White-Box Testing: a SUT belső struktúrája ismert
* IUT, Implementation under test: a SUT azon része, amit tesztelni akarunk
* SUT: a teljes rendszer, amit tesztelünk: vannak olyan részei, amit nem tesztelünk
* modell: a SUT és környezetének absztrakciója, egyszerűsítése
* teszt kontextus: a SUT azon része, amit nem akarunk tesztelni, de rajta kívül érhető el IUT
