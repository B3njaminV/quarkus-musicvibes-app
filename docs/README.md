# Documentation

## MCD

<img src="./mcd/mcd.svg" width="500" height="500">

### Comments

* User

It represents the application user

It can have a library of albums and playlists

It can star artists, albums and songs to analyse their tastes and preferences and offer them personalised content.

* Album 

It represents a list of songs

It has different type : Single, EP (Extended Play), Album

* Artist 

It represents the author of albums

* Playlist 

It will contain music that users can select from to create their own "album".

* Genre 

It represents a genre such as rock or dance

An album and an artist can have a genre to classify them in

## UML 

<img src="./uml/class_diagramm.svg">

## Schema

## users

```js
{	
	_id: ObjectId,
	username: String,
	password: String,

	albums_playlists: [ ObjectId ],
}
```

A user contains a collection of albums and playlists to represents library

## users_stars

```js
{
	_id: ObjectId,
	start_date: ISODate,
	end_date: ISODate,
	user_id: ObjectId,

	artists: [ ObjectId ],
	albums: [ ObjectId ],
	songs: [ ObjectId ],
}
```

We implement Bucket Pattern because 

## albums_playlists

```js
{
	_id: ObjectId,
	name: String,
	cover: String,
	description: String,
	genres: [ String ],
	songs: [
		{
			_id: ObjectId,
			name: String,
			duration: Number,
			genres: [String],
		}
	],

	artist: {
		_id: ObjectId,
		name: String,
		cover: String,
		description: String,
		origin_country: String,
		genres: [String],
	},
}
```

We implement Polymorphic Pattern because album and playlist have common informations

## Update documentation 

For MCD documentation, we use [Mocodo Online](https://www.mocodo.net/)

Copy [mcd.mcd](./mcd/mcd.mcd) and paste it to genrate MCD

For ERD documentation, we use [Star UML](https://staruml.io/) 
