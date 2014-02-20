# Graph Theory Techniques in Model-Based Testing: Harry Robinson, Semantic Platforms Test Group, Microsoft Corporation, Presented at the 1999 International Conference on Testing Computer Software

* szoftvertesztelőnek tanulmányoznia kell a szoftvert a tesztelés előtt
* *pesticide paradox*, a tesztek egyre kevésbé hatékonyak, mert a fejlesztő olyan problémára írja, amit már megoldott
* túl statikusak, nehezen megváltoztathatóak

## Kínai postás problémája

* ha egy gráfban nincs Euler kör, melyik az a bejárás, ahol a legkevesebbszer kell újra bejárni éleket
* Eulerizálás: gráf kiegészítése duplikált élekkel, hogy minden csúcs foka páros legyen

## New York-i utcaseprő problémája

* irányított gráfban
* Eulerizálás: duplikált élek készítése úgy, hogy minden csúcs foka nulla
* cél a tesztelésnél: minden metódus tesztelése effektíven

## de Bruijn szekvencia

* teljes teszt lefedettséget adnak az előző algoritmusok, de nem generálják minden élpár kombináció tesztelését
* de Bruijn szekvencia -> értékpár alapú lefedettség

algoritmus:

1. eredeti gráf duálisának készítése
2. duális gráf eulerizálása
3. bejáráskor az érintett csúcsok listáját készítjük el bejárásként

## egyéb bejárások

* állapottér feldarabolása egyenlőre részekre (Dill, Ho, Horowitz &Yang 1995)
* véletlen bejárás (Nyman 1998):
    + könnyű implementálás
    + hibák hatékony felfedezése a véletlen tulajdonság miatt
    - teszt lefedettség szempontjából nem hatékony
* véletlenszerű bejárás irányítása a fontosabb metódusok felé - Markov láncok - algoritmus:

    1. valószínűség hozzárendelése az élekhez
    2. minimum valószínűség, amely tesztsorozat érdekel minket
    3. bejárás során valószínűségek kummulatív szorzata
    4. végső állapotban, ha minimum valószínűség alá jutunk, akkor nem érdekes ez az útvonal -> új útvonal készítése
    5. ha nagyobb a valószínűség, akkor sorrendbe rendezzük az útvonalakat és legvalószínűbb felé megyünk