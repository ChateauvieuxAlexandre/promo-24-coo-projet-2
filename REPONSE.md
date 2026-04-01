Q1

Non.  
Une méthode `default` d’interface ne peut pas accéder directement aux champs privés d’une classe qui implémente cette interface.  
Elle ne peut utiliser que :
- les méthodes accessibles (publiques/protégées selon le contexte),
- les membres définis dans l’interface elle-même.

Q2

Non, l’inversion n’est pas pertinente ici.

`Machine` doit rester une classe abstraite si elle porte :
- un état commun (attributs d’instance),
- une logique partagée,
- éventuellement un constructeur.

Une interface ne peut pas jouer ce rôle (pas d’état d’instance mutable, pas de constructeur).

`Maintainable` doit rester une interface si c’est une capacité transverse (un contrat que plusieurs types peuvent implémenter).  
Si on la transforme en classe abstraite, on perd la flexibilité, car Java n’autorise qu’un seul `extends` de classe.

Règle pratique :
- interface \= contrat/capacité (\`implements\`) ;
- classe abstraite \= factorisation d’état + comportement commun (\`extends\`).

Q3

`Stock<Duck>` est plus restrictif que `Stock<? extends Duck>` à cause de l’invariance des génériques en Java.

Même si `MiniDuck extends Duck`, on n’a pas :
`Stock<MiniDuck>` \<= `Stock<Duck>`.

Conséquence :
- une méthode `canBeFulfilled(Stock<Duck> stock)` refuse `Stock<MiniDuck>`, `Stock<LuxuryDuck>`, etc. ;
- une méthode `canBeFulfilled(Stock<? extends Duck> stock)` les accepte.

Exemple :

```java
Stock<MiniDuck> miniStock = new Stock<>();
order.canBeFulfilled(miniStock);
```

Q4

`getMachines()` retourne une vue non modifiable pour protéger l'encapsulation de `Factory`.

But : empêcher du code externe de casser des invariants métier, par exemple :
- ajouter/supprimer une machine sans passer par `buyMachine()` (donc sans controle de budget),
- vider/reordonner la liste directement,
- introduire des effets de bord difficiles a tracer.

Si on retournait la liste interne directement, n'importe qui pourrait la modifier, et l'etat de l'usine pourrait devenir incoherent avec les regles du jeu.

Important : `Collections.unmodifiableList(...)` protege la structure de la liste, pas les objets qu'elle contient.
Donc oui, on peut encore modifier les machines elles-memes via leurs methodes publiques (`maintain()`, `degrade()`, etc.) si on y a acces.

Q5

Version Stream en une seule expression :

```java
return produced.entrySet().stream()
		.max(Comparator.comparingInt(Map.Entry::getValue))
		.map(Map.Entry::getKey)
		.orElse(null);
```

Comparaison :
- Imperatif : souvent plus explicite pour debuter (on voit clairement `maxCount` et la boucle).
- Stream : plus compact/declaratif, tres lisible quand on connait l'API.
- Performance : les deux sont en O(n) et tres proches en pratique ici ; l'imperatif peut etre legerement plus direct, mais le gain est negligeable sur une map de petite taille.

Q6

En multi-thread reel, on privilegie les operations bloquantes :
- `put()` cote producteurs : attend si la file est pleine (au lieu d'echouer immediatement comme `offer()`),
- `take()` cote consommateurs : attend si la file est vide (au lieu de retourner `null` comme `poll()`).

Pourquoi :
- evite le busy-wait et les boucles de retry agressives,
- permet une vraie synchronisation producteur/consommateur,
- reduit les pertes de donnees liees a des echecs d'insertion temporaires.

Selon le besoin, on peut aussi utiliser `offer(timeout, unit)` et `poll(timeout, unit)` pour garder un temps d'attente borne.

