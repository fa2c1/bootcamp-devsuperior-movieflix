import './styles.css';

import ReviewForm from '../../../components/ReviewForm';
import ReviewListing from '../../../components/ReviewListing';

function MovieDetails() {
  return (
    <div className='container'>
      <h1>Tela detalhe do Filme</h1>
      <ReviewForm />
      <ReviewListing />
    </div>
  );
}

export default MovieDetails;
