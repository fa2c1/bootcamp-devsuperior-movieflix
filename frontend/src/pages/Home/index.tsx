import { ReactComponent as MainImage } from "assets/images/logo.svg";

import './styles.css';
import Login from './Login';

function Home() {
  return (
      <div className="auth-container">
        <div className="auth-banner-container">
            <h1>Avalie o Filme</h1>
            <p>Diga o que voce achou do seu filme favorito.</p>
            <MainImage />
        </div>
        <div className="auth-form-container">
          <div>
            <Login />
          </div>
        </div>
      </div>
  );
}

export default Home;
