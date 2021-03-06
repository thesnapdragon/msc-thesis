# Saswat Anand, Edmund K. Burke, Tsong Yueh Chen, John Clark, Myra B. Cohen, Wolfgang Grieskamp, Mark Harman, Mary Jean Harrold, Phil McMinn: An orchestrated survey of methodologies for automated software test case generation

* automatikus teszteset generálási lehetőségek ismertetése
* 50%-a a fejlesztési költségeknek

1. szimbolikus futtatás
    * *path constraint* karbantartása a futás során: Boolean formula, melyben a változók értékei írják le, hogy milyen értékek esetén jut abba az állapotba a program
    * kényszermegoldók szükségesek a bonyolultabb Boolean formulákhoz
    * valós programokon való alkalmazása koráltozott 3 nagy proléma miatt:
        * *path exploison*: túl nagy az állapottér, azok kiszámolása is túl sok már
            + egyes részekről összefoglalás készül, hogy módosítják a szimbolikus futtatást
            + csak azon részeket veszi figyelembe, amelyek egy bizonyos célhoz szükségesek
            + ciklusok átalakítása
            + heurisztikák meghatározása, mely path-okat kell választani
            + programrészek kihagyása, melyek nem változtatják az eredményt
        * *path divergence*: nem mindig lehet meghatározni pontosan a kényszereket, amelyek egy path-ra vezetnek: eltérő path-t kapunk a teszteseteknél, mint amiken a program fut
            + manuális felhasználói segítség minimalizálása
        * *complex constraints*: olyan bonyolult is lehet a kényszer, amit a kényszermegoldó nem tud megoldani
            + dinamikus szimbolikus futtatás: ha túl bonyolult lett a kifejezés, valós futtatás eredményeit illesztjük be
            + heurisztikák használata
2. MBT
    * megközelítések:
        * axiomatikus megközelítés
        * véges állapotú automata alapú megbeszélés
        * címkézett tranzíciós
3. kombinatorikus tesztelés
    * bemeneti adatok minden kombinációja
4. véletlenszerű tesztelés
    * ha egy teszteset futtatásával nem sikerült hibát találni, akkor ha hibát akarunk találni a tesztesetnek minél jobban különböznie kell ettől a tesztesettől -> a bemeneteknek az bemenet értékkészletén minél jobban szét kell terülnie
    * módszerek:
        * legjobb jelölt kiválasztása egy véletlenszerű halmazból, valamilyen célfüggvény szerint
        * kizárás alapján: ha a véletlenszerű teszteset nem esik bele egy kizárási régióba, akkor futtatjuk
        * partícionálás: az eddig futtatott tesztesetek információi alapján, a bemeneti értékkészlet partíciókra bontása
        * teszt profilok: ?
        * metrika alapú: szétszórtság, eltérőség alapján következő teszteset választása
5. keresés alapú tesztelés
    * keresési költség minimalizálása + tesztelési célok maximalizálása
    * fitness függvény, mely a keresést vezérli egy tesztelési cél felé
