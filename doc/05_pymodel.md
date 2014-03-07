# PyModel

* [hivatalos honlap](http://staff.washington.edu/jon/pymodel/www/)

* 3 féle modell: modell program, FSM, test suite
* modell leírása kóddal: nyomok (trace) sorozata, melyek akciókból állnak
* modell leírása FSM-mel: átmenetek = akciók; útvonalak = nyomok
* a nyomokat tesztesetekként lehet használni
* teszt oracle
* teszt adapter (PyModel terminológiában *stepper*)
* modellkompozíció (több különféle modell például program modell és FSM kombinációjából álló új modell)
* tesztforgatókönyv (scenario), különböző stratégiák (állapot-, átmenetlefedettség)

## Részek

* pma: PyModel Analyzer - validálja a modellprogramot és FSM-et készít belőle
* pmg: PyModel Graphics - grafikusan ábrázolja az FSM-et
* pmt: PyModel Tester - offline tesztesetek generálása, online tesztesetek készítése és futtatása
* pmv: pma + pmg
