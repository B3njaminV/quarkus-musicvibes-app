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

<img src="./uml/class_diagram.svg">

## MongoDB Schema

## User

```js
{	
	_id: ObjectId,
	username: String,
	password: String,

	library: [ 
		{
			album_playlist_id: ObjectId,
			is_like: Boolean
		}
	],
}
```

A user contains a collection of albums and playlists to represents his library


## AlbumPlaylist

```js
{
	_id: ObjectId,
	name: String,
	cover: String,
	type: String,
	description: String,
	genres: [String],
	songs: [
		{
			_id: ObjectId,
			name: String,
			duration: Number,
			genres: [String],
			featuring: [ObjectId]
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


## Genre

```js
{
	_id: ObjectId,
	name: String,
	cover: String,
}
```

## Update documentation 

For MCD documentation, we use [Mocodo Online](https://www.mocodo.net/)

Copy [mcd.mcd](./mcd/mcd.mcd) and paste it to genrate MCD

For UML documentation, we use [Star UML](https://staruml.io/) 
