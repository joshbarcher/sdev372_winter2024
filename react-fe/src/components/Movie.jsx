import './Movie.css';

export default function Movie({ movie }) {

    return (
        <section className="movie">
            <h2>{movie.title}</h2>
            <p>Genre: {movie.genre}</p>
            <p>Released: {movie.releaseYear}</p>
            {/* <p>International? {international}</p>
            <p>Rating: {rating}</p> */}
        </section>
    )
}