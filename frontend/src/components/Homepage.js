import React from "react"
import Forma from "./Forma.js"
import TableTakmicari from "./TableTakmicari.js";
import Pretraga from "./Pretraga";

class Homepage extends React.Component {

    constructor(props) {
        super(props);

    }

    render() {
        return (
            <div style={{marginTop:"50px"}}>
                <Forma />
                <Pretraga />
                <TableTakmicari />
            </div>

        )
    }

}

export default Homepage