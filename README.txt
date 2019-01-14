Vilcea Alexandru
324CC
Grad de dificultate: ridicat
Timpul alocat rezolvarii temei: 67 de ore alocate in felul urmator:
	1. in prima saptamana de vacanta minim 3 ore pe zi(3*5 = 15 ore) 
	2. 27-31dec cate 4-5 ore pe zi(18 ore) 
	3. 3-6ian cate 5-6 ore pe zi(22 de ore) 
	4. prima saptamana de scoala(12 ore)
	Tot legat de timp consider ca acesta nu a fost suficient. Se presupune ca tema se poate rezolva in 14 zile. 
	Eu in 67 de ore am reusit sa rezolv doar prima parte a temei. Daca lucram teoretic inafara vacantei trebuia sa aloc 5 ore pe zi doar pentru prima parte a temei (in conditiile in care se suprapune si cu alte 2 teme si alte teste de curs + timpul petrecut la facultate)...
	IMPOSIBIL de rezolvat toata tema!(parerea mea)

Mod de implementare:
	-Store: 
		1.contine o lista de tip LinkedList a departamentelor si alta a clientilor din magazin
		2.implemnteaza patternul singletone astfel incat sa existe o singura instanta acestei clase
		3.implemnteaza metodele cerute in enunt
	-Department:
		1.contine o lista de tip LinkedList a produselor din departament, o alta lista a clientilor cumparatori/wishers din departament, o lista de tip ArrayList a observatorilor
		2.clasa departament implemnteaza Subject-interfata pentru a respecta patternurile
		3.implemnteaza metodele cerute in enunt
		4.am adaugat o noua metoda boolean depContainsItem(Item item) - verifica daca in departament exista un item cu acelasi id ca cel transmis prin parametru
	-Item:
		1.contine datele din enunt
		2.Getters&Setters si un toString
	-Customer
		1.contine datele din enunt, de mentinoat ca am ales ca si colectie de notificari un ArrayList
		2.implementeaza interfata Observer ponform patternului descris in enunt
	-ItemList
		1.Contine o clasa interna Node care este implementata dupa modelul listelor dublu inlantuite
		2.Contine o clasa ItemIterator cu 2 atribute: nodul curent si indexul la care s-a ajuns. 
		Implementeaza metodele lui ListIterator, pe care am incercat sa le fac sa functioneze pe toate cazurile posibile, metode care functioneaza dupa modelul iteratorilor gata implementati
		(Aici ma refer la urmatorul exemplu: iterator.next->returneaza obiectul curent si incrementeaza iteratorul)
		3.Contine un comparator pentru a sorta produsele
		4.Metodele add si remove din ItemList folosesc iteratorul si totodata metodele de add si remove din clasa ItemIterator.
		5.Celelalte metode sunt de asemenea se folosesc de acest iterator.
		6.Clasa TestItemList este o clasa pe care am folosit-o sa testez iteratorul si clasa ItemList pe toate cazurile posibile pentru a fi sigur ca nu am omis niciun caz in implementare. Am ales sa nu o sterg din proiect.
		7.De mentionat este ca atat in SC cat si in WL se afla dubluri de produse cu aceleasi date ca cele retinute in clasa Department.(pentru a modifica la apelarea functiilor accept doar produsele unui client, nu si in departament. M-am lovit de aceasta problema)
		8. nu exista metode abstracte deoarece nu le-am considerat necesare
		9. nu toate metodele date in exemplu sunt implementate deoarece nu au relevanta in modul de functionare al programului
	-ShoppingCart
		1. Foloseste metodele din ItemList + modificari ale bugetului
		2. Foloseste visitor pattern si aici se modifica pretul produselor la apelarea metodelor accept
	-Notification
		1. Foloseste o enumeratie, recunosc ca nu i-am inteles exact sensul dar am stiut sa o implemnetez(ma refer la enumeratie)
	-Test
		1.Am foslosit mai multe metode ajutatoare pentru claritatea codului
		2.readStore citeste fisierul store.txt si creeaza departamentele si produsele din fiecare departament
		3.readCustomer face acelasi lucru insa pentru clienti
		4.readEvents citeste inputul din events.txt, il parseaza si apoi este transmis unei functii eventHandler, care apeleaza metodele in care sunt implementate rezolvarile diverselor evenimente
		5. tot in eventHandler se si scrie in fisierul de iesire

Concluzie personala:
	A fost o tema interesanta la care mi-a facut placere sa lucrez. Am invatat multe concepte noi si le-am aprofundat pe cele deja invatate. M-a ajutat foarte mult aceasta tema insa cel mai mare minus il reprezinta timpul foarte scurt pentru o tema atat de complexa. Mi-ar fi facut placere sa pot sa implementez si a doua parte.

Vilcea Alexandru


