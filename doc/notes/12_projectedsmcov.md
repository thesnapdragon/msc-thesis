# G. Friedman, A. Hartman, K. Nagin, T. Shiran: Projected State Machine Coverage for Software Testing

* problémák:
  * túl nagy állapottér, túl sok teszteset
  * nem determinisztikus rendszerek
* lefedettségi kritériumok, tesztelési kényszerek -> megoldják a fenti problémákat
* FSM: vezérlési szerkezet leírása (leírja mely input esetén, milyen állapotból -> milyen output, milyen állapotba lép)
* EFSM: vezérlési szerkezet + adatmodellezés (a fentieken kívül minden állapothoz tartozik változók egy halmaza, melyben egyéb információkat tárolunk)
* G gráf:
  * csúcsok: állapot × output
  * élek: lehetséges inputok
* algoritmusok:
  * BFS: FIFO sor, rövid tesztesetek
  * DFS: LIFO stack, hosszú tesztesetek
  * CFS (coverage first search): az állapottér felderítése először
