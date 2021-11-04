const API = "http://localhost:4000/song"


function readInput() {
    var userInput = document.getElementsByName("input")[0].value;
}

function getAllSongs(){
    const DATA = {
        songs: [
            {
                name: '',
                artist: ''
            }
        ]
    }

    let playlistContainerContents = "";

    DATA.songs.forEach(
        song => {
            playlistContainerContents += `
    <div class="SongDataNode">
       <b>Name:</b> ${song.name} <br/>
       <b>Student No:</b> ${song.artist}
    </div>
            `;
        }
    )
    console.log(playlistContainerContents);
    document.querySelector("#playlistContainer").innerHTML = playlistContainerContents;

    fetch(API).then(
        res => {
            res.data.songs.forEach(
                song => {
                    playlistContainerContents += `
    <div class="songDataNode">
       <b>Name:</b> ${song.name} <br/>
       <b>Student No:</b> ${song.artist}
    </div>
            `;
                }
            );

            document.querySelector("#playlistContainer").innerHTML = playlistContainerContents;
        }
    )
//    Update the DOM
}
getAllSongs()