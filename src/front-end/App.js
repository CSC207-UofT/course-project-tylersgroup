import React from "react";
import {Route, Switch} from "react-router-dom";
import LandingPage from "./comps/LandingPage";
import TopArtists from "./comps/TopArtists";
import "./App.css";


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