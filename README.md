# Projet de Génie Logiciel

Ce projet vise à creer un clone du jeu Eternity en utilisant des méthodes agiles:

Guide d'installation:

 * installer Git sur le pc $ sudo apt-get install git
 * configurer ssh suivre la documentation de github
 * dans le terminal:
 
```javascript
git clone https://github.com/Jbaud/GLPOO.git
```
 Cela va creer un un dossier GLPOO.
```javascript
cd GLPOO/
```
A l'interieur se trouvera le projet maven, pour generer un projet eclipse:

```javascript
mvn install 
```
et enfin
```javascript
mvn eclipse:eclipse 
```
Maintenant vous pouvez importer le projet depuis eclipse

-------------------------------------------

Pour l'aide se trouve [ici](http://rogerdudler.github.io/git-guide/)

##### Mais n'oubliez pas de créer une branche chacun.

-------------------------------------------

Autrement avant de pouvoir push votre code il faut recreer un package maven, pour ce faire.

```javascript
mvn compile
```
```javascript
mvn package
```
```javascript
mvn install
```




et push

