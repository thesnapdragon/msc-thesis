# Utting, M., Pretschner, A. and Legeard, B. (2012), A taxonomy of model-based testing approaches. Softw. Test. Verif. Reliab., 22: 297–312. doi: 10.1002/stvr.456

A tesztelés célja a hiba detektálás, mely során egy szoftver elvárt és az aktuális működését összehasonlítjuk. A modell alapú tesztelés (modell based testing, MBT) a tesztelés egy változata, ahol viselkedési modellekel írjuk le a tesztelni kívánt szoftver (system under test, SUT) viselkedését. A modellekből tesztek generálhatóak, melyek később futtathatóak a szoftveren.

Motiváció: általában a tesztek stuktúrálatlanok, reprodukálhatatlanok, nem dokumentáltak és korlátjuk az őket megalkotó mérnök leleményessége

## Fogalmak

* teszteset: bemenet + elvárt kimenet
* test suite: tesztesetek véges halmaza
* teszt szkript: futtatható kód, meg futtatja a tesztesetet a SUT-on
* adapter: a SUT és az absztrakt modell kapcsolóeleme
* MBT: folyamat és technikák absztrakt modell alapján -> absztrakt tesztesetek -> konkrét tesztesetek generálása -> konkrét tesztesetek futtatása manuálisan vagy automatikusan

1. Teszt modell készítése, követelmények és specifikáció alapján
2. Teszteset kiválasztási kritériumok meghatározása
3. Teszteset specifikáció készítése
4. Tesztesetek generálása teszteset specifikáció és a modell alapján
5. Teszteset futtatása

## MBT taxonómia

1. Modell hatásköre: csak bemenetet / bemenet + elvárt kimenetet specifikálja
2. Modell karakterisztika: determinisztikusság / időzítés / DI vagy FI
3. Modellezési paradigma (modell elkészítésének alapkoncepciója): állapot alapú (változók + operációk) / átmenet alapú (állapotgép) / történet ? előzmény alapú / funkcionális / működési / sztochasztikus / adatfolyam
4. Teszteset kiválasztási kritérium (modellből milyen szempont alapján választunk tesztesetet): modell lefedettség / adat lefedettség (bemenetekből ekvivalencia osztályok készítése) / követelmény alapú lefedettség / ad-hoc tesztesetek / véletlen és sztochasztikus tesztesetek / hiba alapú teszteset választás
5. Teszt generálási technológia (modellből milyen módon választjuk ki a teszteseteket): véletlenszerű bejárás / keresés alapú algoritmusok / (korlátos) modellellenőrzés / szimbolikus futtatás / deduktív tétel bizonyítás / kényszermegoldó alapú
6. Teszteset futtatás: online (lehetőség a SUT állapotaira leagálni a teszt során) / offline
