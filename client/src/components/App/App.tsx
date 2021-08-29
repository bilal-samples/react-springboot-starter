import React from 'react';
import './App.css';
import {Container} from "@material-ui/core";
import Header from "../Header";
import Form from "../Form/Form";


function App() {

    return (
        <div className="App">
            <Header title="React-SpringBoot-Postgresql Starter"/>

            <Container maxWidth="lg">
                <Form/>

            </Container>
        </div>
    );
}

export default App;
