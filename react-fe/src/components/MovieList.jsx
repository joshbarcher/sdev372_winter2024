import Movie from "./Movie";
import './MovieList.css';
import { useState, useEffect } from 'react';

export default function MovieList() {
    const [ movies, setMovies ] = useState([])

    //the second parameter is an empty array that's declaring
    //that the side effect should only ever run once
    useEffect(() => {

        //this nested function will gather our data
        const fetchData = async () => {
            //gather up the data from the API back-end
            const response = await fetch('http://localhost:3000/api/v1/movies/all', {
                method: 'get'
            })
            const data = await response.json();

            setMovies(data);
        }

        //start the asynchronous call to the backend
        fetchData();
    }, [])

    return (
        <main>
            <h1>Welcome to my Application</h1>
            <p>Check out my movies!</p>
            <hr />
            <div id="movie-group">
                {
                    movies.map(el => <Movie key={el.title} movie={el} />)
                }
            </div>
        </main>
    );
}