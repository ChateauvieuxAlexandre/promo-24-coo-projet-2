
Q1
Non, une méthode default d’interface ne peut pas accéder directement aux champs privés d’une classe qui l’implémente.

Q2

On ne peut pas vraiment inverser proprement car `Machine` porte un socle commun (état + logique), ce qui correspond à une classe abstraite.
Si `Machine` devenait une interface, elle ne pourrait pas avoir d’état d’instance ni de constructeur (seulement des constantes), donc on perdrait ce rôle.
Et si `Maintainable` devenait une classe abstraite, on perdrait la souplesse du contrat transverse, car une classe Java ne peut étendre qu’une seule classe (héritage simple).

Règle générale :
- on choisit une interface pour définir un contrat/capacité (`implements`) potentiellement partagé par des classes sans lien hiérarchique ;
- on choisit une classe abstraite pour factoriser de l’état et du comportement commun (`extends`) entre classes proches.

