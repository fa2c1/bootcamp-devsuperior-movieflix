import { Route, Router, Switch } from 'react-router-dom';

import history from 'util/history';

import Navbar from './components/Navbar';
import PrivateRoute from 'components/PrivateRoute';
import Home from './pages/Home';
import MovieCatalog from './pages/Private/MovieCatalog';
import MovieDetails from './pages/Private/MovieDetails';

const Routes = () => (
  <Router history={history}>
    <Navbar />
    <Switch>
      <Route path='/' exact>
        <Home />
      </Route>
      <PrivateRoute path='/movies'>
        <Route path='/movies' exact>
          <MovieCatalog />
        </Route>
        <Route path='/movies/:movieId' exact>
          <MovieDetails />
        </Route>
      </PrivateRoute>
    </Switch>
  </Router>
);

export default Routes;
