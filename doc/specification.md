# Specification


## Introduction

### Purpose

Many music streaming platforms allow users to create playlists to save and sort songs. Other users can access these shareable playlists. Some users of these music platforms like to create playlists, in which the title of each songs form a meaningful sentence. 

The purpose of this program is to generate playlists (group of songs) based on a sentence inputted by the user. By splitting the input sentence into parts, and finding songs whose titles are composed of these parts, a playlist is generated. It then gets added to the  user’s account and the user can also edit the contents of the playlists. 

### Intended Audience

This program is intended to be used by anyone who is also using one of the supported music streaming platforms.

***

### Potential extensions:
* Social functionality
* Share, merge and compare playlists
* Use web sockets to allow multiple users to write a sentence at the same time
* When creating playlists, only include songs of a specific genre
* Integrating with spotify's playlist functions (title, description, image, etc.)

***

## Running the program

Running the program starts a text based user input environment that allows the user to input a string to interact with a menu interface

### Login/Create Account

Upon running the program, the user will be asked to login or create a new account

* Login
	* If the user chooses to login, the program will read in the user’s username and password before checking if they match with what is stored in the database. 
	* If the username and password match with an account in the database then the user is logged in. Otherwise an error message “username or password invalid” is printed and they are prompted to try again or create a new account

* Create new account 
	* If the user chooses to create a new account the program takes inputs of username and password from the user. The program then creates a new user with the above information and stores the new user information on an external database. They are then automatically logged in.

***

### Main Menu

Upon successful login, users can do one of the following: 

* Create new playlist from string
	* If the user wants to create a playlist, they are prompted to enter a string of words which the program then splices in multiple different combinations to be able to find song titles for each word or group of words
	* Once an array of song names is generated then song entities are created and added to a playlist entity which is then assigned to the user’s account

* Manage saved playlists
	* Once the user has a number of saved playlist they can then edit and manage their playlists, deleting playlists they no longer want and changing the playlist name

* Account settings 
	* If the user chooses account settings they can change their username and password

* Logout

