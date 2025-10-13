# Esercizio con Git, in locale

Per ogni passo,
si annoti in questo file il comando utilizzato ed il suo output,
per confrontarlo con le soluzioni.

### Si crei una nuova directory

### Si inizializzi un repository Git dentro la cartella suddetta.
git init
Initialized empty Git repository in C:/Users/Toba-/OneDrive/Documentos/unibo/OOP/LAB/43-git/.git/
### Si osservi lo stato del repository
git status
On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        README.md

nothing added to commit but untracked files present (use "git add" to track)
### Si scriva un file `HelloWorld.java` contenente un `main` con una stampa a video e si osservi il contenuto del repository
echo > HelloWorld.java
code .\HelloWorld.java
git status

On branch master

No commits yet

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        HelloWorld.java
        README.md

nothing added to commit but untracked files present (use "git add" to track)

### Si aggiunga `HelloWorld.java` allo stage, e si osservi lo stato del repository
git add HelloWorld.java
git status

On branch master

No commits yet

Changes to be committed:
  (use "git rm --cached <file>..." to unstage)
        new file:   HelloWorld.java

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        README.md
### Si crei il primo commit, con messaggio ragionevole. Se necessario, si configuri nome utente ed email di git usando i dati dell'account istituzionale.
git commit -m 'initial commit'

[master (root-commit) 9c71b27] initial commit
 2 files changed, 87 insertions(+)
 create mode 100644 HelloWorld.java
 create mode 100644 README.md
### Si compili il file Java e si verifichi lo stato del repository
javac HelloWorld.java
git status

On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   README.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .gitignore
        HelloWorld.class
### Si noti che c'è un file rigenerabile (`HelloWorld.class`). Si costruisca una lista di file ignorati che ignori tutti i file con estensione `.class`
git add .gitignore

### Si osservi lo stato del repository
git status  

On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   .gitignore

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   README.md
### Si crei un nuovo commit che tracci il la ignore list, aggiungendo allo stage i file necessari. Si osservi sempre lo stato del repository dopo l'esecuzione di un comando
git commit -m 'gitignore with *.class'  


[master ca11ac2] gitignore with *.class
 1 file changed, 1 insertion(+)
 create mode 100644 .gitignore


git status


On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   README.md

no changes added to commit (use "git add" and/or "git commit -a")
### Si gestiscano i caratteri di fine linea in modo appropriato, creando un file `.gitattributes`
echo > .gitattributes

cmdlet Write-Output at command pipeline position 1
Supply values for the following parameters:
InputObject[0]:

code .gitattributes

### Si osservi la storia del repository usando `git log --all --graph`
git log --all --graph

:
| Author: Tobias Basilisco <tobias.basilisco@studio.unibo.it>
| Date:   Mon Oct 13 18:03:29 2025 +0200
|
|     gitignore with *.class
|
* commit 9c71b2701d3119b5a8fbe66d8215cc011707ae78
  Author: Tobias Basilisco <tobias.basilisco@studio.unibo.it>
  Date:   Mon Oct 13 17:56:14 2025 +0200

      initial commit

### Da questo punto in poi, prima e dopo ogni comando, ci si assicuri di osservare lo stato del repository con `git status`

### Si crei un file Mistake.java, con contenuto arbitrario, lo si aggiunga al tracker, e si faccia un commit

### Si rinomini `Mistake.java` in `ToDelete.java`, e si faccia un commit che registra la modifica

### Si elimini `ToDelete.java` e si registri la modifica in un commit
git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   .gitattributes

Changes not staged for commit:
  (use "git add/rm <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        deleted:    Mistake.java
        modified:   README.md

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        ToDelete.java
### Si osservi la storia del repository e si identifichi il commit dove è stato creato `Mistake.java`. Per una visione compatta, si usi l'opzione `--oneline`

### Si ripristini Mistake.java dal commit identificato al passo precedente
git checkout b2bc0c6 -- Mistake.java
PS C:\Users\Toba-\OneDrive\Documentos\unibo\OOP\LAB\43-git> git status
On branch master
Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   Mistake.java

Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   README.md
### Si rimuova il file ripristinato e si ripulisca lo stage

### Si torni al commit precedente a quello in cui `Mistake.java` è stato creato. Si utilizzi la storia del repository se utile.
git checkout b2bc0c6                 
Note: switching to 'b2bc0c6'.

You are in 'detached HEAD' state. You can look around, make experimental
changes and commit them, and you can discard any commits you make in this
state without impacting any branches by switching back to a branch.

If you want to create a new branch to retain commits you create, you may
do so (now or later) by using -c with the switch command. Example:

  git switch -c <new-branch-name>

Or undo this operation with:

  git switch -

Turn off this advice by setting config variable advice.detachedHead to false

HEAD is now at b2bc0c6 mistake
M       README.md