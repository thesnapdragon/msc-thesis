# M. Shafique, Y. Labiche. A systematic review of state-based test tools. STTT, 2013.

## Fogalmak

* teszt csonk: SUT egy részének szimulációja
* test oracle: teszt sikerességének ellenőrzése
* black-box test: funkcionális, a szoftver specifikációhoz hasonlítja
* white-box test: struktúrális, a szoftver implementációját használja

# Értékelési szempontok

* eszközök melyek véges automatákat (állapotgépeket) használnak modellként: FSM, EFSM, ASM, UML állapotdiagram, LTS, Harel állapotdiagram
* eszközök értékelése több szempont szerint:
    * *test criteria*:
        * *model-flow criteria* = modellezési paradigma: átmenetek, állapotok, állapotpárok, (minden bejárás, *sneak path* (olyan útvonal, ami nem lenne elfogadható), forgatókönyv)
        * *script-flow criteria* = a rendszer viselkedésének bővebb leírásának módja: interfész, őrök, feltételek
        * *data criteria* = lehetséges bemeneti adatok formátuma: egy érték, több érték, korlátotok, értékpárok
        * *requirement criteria* = követelmények teljesítésének követése modell alapján
    * *test scaffolding*:
        * adapter készítés
        * oracle készítés
        * teszt stub készítés
        * online tesztelés
        * offline tesztelés

# Eszközök

* TestMaster: állapot alapú, modell készítése külön eszközzel, modell során meghatározott követelményeknek megfelelés
* GOTCHA-TCBeans: modell saját nyelven (GDL), tesztesetek XML-ben adapter készítése hozzájuk
* GraphWalker: modell GraphML formátumban (yED eszközzel készíthetőek), adapter + oracle készítés, TestNG futtatja a teszteket
* TestCast: Eclipse plugin, XMI formátumban olvas be állapotgépeket, UPPAAL CORA + MTL segítéségvel tesztesetek készítése
* NModel: modell C# osztályok alapján, változók = állapotok
* PyModel: FSM alapján gráf készítése vagy modell program alapján FSM készítés, többféle stratégia a bejárásra
* SpecExplorer: ASM modell C# szerű kód alapján, adapter + oracle szkeleton generálás
* TestOptimal: modell GraphML, XMI, vagy GraphXML formátumban, adapter szkeleton generálás
* AGEDIS: modell beépített UML modellező eszközzel, események IF (Intermediate Format) annotációval, tesztesetek XML-ben
* Conformiq: UML modellező, események Qtronic Modeling Language segítségével, többféle adapter nyelv támogatás
* ParTeG: Eclipse plugin, modell készítése TopCased eszközzel UML osztály és állapotdiagrammok, JUnit tesztesetek
* Smartesting CertifyIt: modell = UML + Business Process Model + megjegyzések, események Object Constraint Language segítségével

# Levont tanulságok

* lefedettség általában egyszerű szempontok (állapotok, események) alapján, bonyolultabbak nem támogatottak pl esemény párok
* őr feltételek támogatása ritka
* több féle bemeneti formátum támogatása ritka
* teszteléshez szükséges kiegészítő elemek készítése (test scaffolding) hiányos
* third party eszközök használata miatt nehezebb a használatuk
