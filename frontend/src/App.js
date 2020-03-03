import React, {Component, useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import Homepage from "./components/Homepage";

class App extends Component {

    componentDidMount() {
        fetch("/api/skakaonice")
            .then(response => response.json())
            .then(data => console.log(data))
    }


    render() {
        return (
            <Homepage />
        )
    }

}

export default App;
