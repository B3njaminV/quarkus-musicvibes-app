# Documentation

<details>
<summary> MCD </summary>
<h2> MCD </h2>

<img src="./mcd/mcd.svg" width="500" height="500"/>

<h4> MCD Comments </h4>

<ul>
<li> User </li>
<p>He represents the application user.<p>
<p>He have a library of albums and playlists</p>
<p>He can like an album to keep it as a favourite, and with statistics, the application can suggest similar content.</p>

<li> Album </li>
<p>It represents a list of songs created by an artist</p>
<p>It has a type : Single, EP (Extended Play), Album</p>

<li>Artist</li>
<p>It represents the author of albums</p>

<li>Song</li>
<p>It represents the song of an album</p>
<p>It can contains a list of artist featuring on it</p>

<li>Playlist</li>
<p>It will contain music that users can select from to create their own "album".</p>

<li>Genre</li>
<p>It represents a genre such as rock or dance</p>
<p>An album, an artist and a song can have a genre to classify them in</p>
</ul>	
</details>

<details>
<summary> UML </summary>
<h2> UML </h2>

<img src="./uml/class_diagram.svg">
</details>

<details>
<summary> MongoDB Schema </summary>
<h2> MongoDB Schema </h2>

<h4> User </h4>

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

<h4> AlbumPlayist </h4>

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
			name: String,
			duration: Number,
			genres: [String],
			featuring: [ObjectId]
		}
	],

	artist: {
		name: String,
		cover: String,
		description: String,
		origin_country: String,
		genres: [String],
	},
}
```

We implement Polymorphic Pattern because album and playlist have common informations

<h4> Song </h4>

```js
{
	_id: ObjectId
	name: String,
	duration: Number,
	genres: [String],
}
```

<h4> Artist </h4>

```js
{
	_id: ObjectId
	name: String,
	cover: String,
	description: String,
	origin_country: String,
	genres: [String],
}
```

<h4> Genre </h4>

```js
{
	_id: ObjectId,
	name: String,
	cover: String,
}
```
</details>

## Update documentation 

For MCD, we use [Mocodo Online](https://www.mocodo.net/)

Copy [mcd.mcd](./mcd/mcd.mcd) and paste it to genrate MCD

For UML, we use [Star UML](https://staruml.io/) 

For Database we use [MongoDB](https://www.mongodb.com/)