<p align="center">
<img alt="DataHub" src="https://cdn.arstechnica.net/wp-content/uploads/2023/03/apple-music-classical.jpg" height="200px" />
</p>
<h1 align="center"> Quarkus MusicVibes API 👋</h1>

🏠 [Homepage](https://codefirst.iut.uca.fr/git/benjamin.valleix/quarkus-musicvibes-app) |
💻 [Application react](https://codefirst.iut.uca.fr/git/benjamin.valleix/react-musicvibes-app) |
📰 [Documentation](https://codefirst.iut.uca.fr/git/benjamin.valleix/quarkus-musicvibes-app/src/branch/master/docs)

---

## 📣 Introduction
MusicVibes API est développée à l'aide du framework Quarkus et utilise MongoDB comme base de données.
Cette application est une API REST concu pour récupérer divers informations pour une application de musiques.
Vous pourrez trouver la documentation [ici](https://codefirst.iut.uca.fr/git/benjamin.valleix/quarkus-musicvibes-app/src/branch/master/docs)

## 📍 Prérequis

- Quarkus

## ‍💻 Collection MongoDB 

Vous pouvez trouver un exemple d'ensemble de données dans le dossier `data`
```sql
mongoimport --collection song song.json --db musicvibes
mongoimport --collection albumPlaylist albumPlaylist.json --db musicvibes
```

## ‍💻 Services

Les différentes requêtes de recherche et la création des indexs se trouve dans les 2 fichiers repository `SongRepository` et `AlbumPlaylistRepository`

## ✍️ Auteur

👤 **VALLEIX Benjamin**

* GitHub: [@B3njaminV](https://github.com/B3njaminV)
* LinkedIn: [@Benjamin VALLEIX](https://www.linkedin.com/in/benjamin-valleix-27115719a)

👤 **BREUIL Yohann**

* GitHub: [@DJYohann](https://github.com/DJYohann)
* LinkedIn: [@BREUIL Yohann](https://www.linkedin.com/in/yohann-breuil-02b18a165/)

👤 **TAHA JANAN Ismail**

* LinkedIn: [@TAHA JANAN Ismail](https://www.linkedin.com/in/ismail-taha-janan-b63a94166/?originalSubdomain=ma)


## 📝 License

Copyright © 2023
