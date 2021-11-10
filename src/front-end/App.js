import React from "react";
import {Route, Switch} from "react-router-dom";
import LandingPage from "./comps/LandingPage";
import TopArtists from "./comps/TopArtists";
import "./App.css";

//currently the web app will first send the user to the landing page where they will be prompted to log in to their
// spotify account, and once they have logged in they will be send to a page where they can view their top ten artists.
//temporary for testing purposes, after first we should have our app send to our own login, then spotify account
// login authentication.

function App() {
    return (
        <div>
            <Switch>
                <Route exact path = "/" component = {LandingPage} />
                <Route exact path = "/top-artists" component = {TopArtists} />
            </Switch>
        </div>
    );
}

export default App;