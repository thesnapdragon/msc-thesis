# 2014.02.06.

* féléves terv körvonalazása
* elképzelések a teljes feladatról
* 2 bevezető jellegű dokumentum elolvasása:
  * Utting, M., Pretschner, A., Legeard, B.: A taxonomy of model-based testing. STVR 22:5, 2012.
  * M. Shafique, Y. Labiche. A systematic review of state-based test tools. STTT, 2014.

# 2014.02.14.

* SCXML állapotgépek leírásához
* egyszerű állapotgépes példák készítése
* egyszerű algoritmusok implementálása
* teszt lefedettség: átmenetek alapján

# 2014.02.21.

* több rövidebb tesztsorozat készítése, próbálkozással
* kipróbálni az algoritmusokat, próbálkozásokat: legyenek példa implementációk
* hibás állapotgép kipróbálása

# 2014.02.25.

* közös megbeszélés, hosszú távú célok meghatározása
* egymás feladatainak megismerése

# 2014.02.28.

* PyModel
* GraphWalker
* irányított chinese postman
* calculator implementáció, tesztelni
* kérdés: Mi történik akkor, hogy ha egy programnak több végállapota is van, ahonnan nem tud új állapotba kerülni?

# 2014.03.07.

* PyModel kipróbálni
* GraphWalker kipróbálni, dokumentációból érdekes részeket kijegyzetelni

# 2014.03.14.

* guardok vizsgálata PyModel-ben, GraphWalker-ben

# 2014.03.21.

* Model-Based Testing of Reactive Systems olvasás, jegyzetelés
* saját szkript guard implementáció

# 2014.04.04.

* guard implementáció saját szkriptben
* beszámoló részeinek végiggondolása, vázlat készítése

# 2014.10.24.

* leadott jegyzőkönyv tapasztalatainak átbeszélése

# 2014.10.01.

* guardok kipróbálása Python szkriptben
* An orchestrated survey of methodologies for automated software test case generation
* (A Generic Fault Model for Quality Assurance)
* példa állapotgépek őrfeltételekkel (egymásnak ellentmondó / átlapolódó / ...)
* őrfeltétel nyelve?
* Répás Gergő. "Biztonságkritikus beágyazott rendszerek szisztematikus tesztelése" TDK 2007: állapotgép modellek, saját szöveges szintaxis nyelv, tesztgenerálás SAL-ATG-vel, saját C felműszerező és lefedettséget mérő eszköz (pdf a FTSRG WIKI csatolt fájloknál)
* http://ucaat.etsi.org/2014/Program.html

# 2014.11.12.

* Implementing Conformiq Qtronic
* Language Specific Analysis of State Machine Models of Reactive Systems
* Projected Statemachine coverage for software testing
* Test Models and Coverage Criteria for Automatic Model-Based Test Generation with UML State Machines
* saját példákat Conformiq-ban lefuttatni
* Tóth Tamás-nak írni

# 2015.02.18.

* Darvas Dani dokumentációk olvasása

# 2015.03.11.

* Daninak írni példamodellekért
* megkérdezni, hogy áll a modellellenőrző?
 + modellellenőrzőt megismerni
 - Oszkár - kényszermegoldó kérdés; statemachine - constraint solving leképezés
* kézzel őrfeltételes állapotgépek alapján tesztesetek készítése

# 2015.03.18.

* állapotgépek leképezése Alloy-ra; Alloy tutorialok
* contraint solving: SAT solvers, SMT solvers

# 2015.03.25.

* tesztgenerálás állapotgépek alapján

# 2015.04.01.

* átmenetlefedettség vizsgálat Alloy tesztgenerálásnál

# 2015.04.08.

* tesztgenerálás további vizsgálatok
* példánymodell leképezése Alloy-ra

# 2015.09.23.

* Acceleo:
  * http://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.acceleo.doc%2Fpages%2Freference%2Flanguage.html

# 2015.09.26.

* Eclipse pluginek:
  * http://www.vogella.com/tutorials/EclipsePlugIn/article.html
  * https://spring.io/guides/gs/maven/
  * http://www.javaworld.com/article/2071772/java-app-dev/the-maven-2-pom-demystified.html
* Alloy:
  * http://alloy.mit.edu/alloy/code/ExampleUsingTheCompiler.java.html
* Notes:
  * http://robertvarttinen.blogspot.hu/2007/01/adding-third-party-jar-to-your-eclipse.html

# 2015.09.29.

*  -XX:MaxPermSize=128M

# 2015.10.01.

* absztrakt test definíciós nyelv
1. hibás demonstrációs eset
	* JUnit tesztek
	* mutációs teszteléssel ellenőrizni (Major, mutation-testing.org)
2. minél teljesebb modell, minél több felhasznált elem
3. skálázhatóság: generált modell

# 2015.10.04.

* különböző solverek teljesítményének mérése (state: MiniSAT, transition: Lingeling)
* -Xms128m -Xmx1024m -XX:MaxPermSize=128M
* telepítés: https://www.chilkatsoft.com/java-loadLibrary-MacOSX.asp
* metamodell készítése interfész alapján: http://help.eclipse.org/mars/topic/org.eclipse.emf.doc/tutorials/clibmod/clibmod.html?cp=20_1_0#step1b
* példánymodell készítése kódból: http://www.vogella.com/tutorials/EclipseEMFPersistence/article.html