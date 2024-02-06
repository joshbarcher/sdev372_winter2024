//wait until the page loads
window.onload = function() {
    //fetch the data
    const uri = "http://localhost:3000/api/v1/movies/all";
    const config = {
        method: 'get'
    }
    fetch(uri, config)
        .then(function(response) {
            console.log(response);

            //returns another promise
            return response.json();
        })
        .then(function(data) {
            //update our UI
            console.log(data);
            showMovies(data);
        });
}

function showMovies(movies)
{
    const section = document.querySelector("#movies");
    console.log(section);

    //loop over each of my movies and add a nested element
    for (let i = 0; i < movies.length; i++)
    {
        const movie = movies[i];

        section.innerHTML += `<div class="movie">
                <h2>${movie.title}</h2>
                <p>ID #${movie.id}</p>
                <p>Genre: ${movie.genre}</p>
            </div>`;
    }
}