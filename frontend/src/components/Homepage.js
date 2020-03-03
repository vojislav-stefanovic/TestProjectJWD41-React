import React from "react"

class Homepage extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            takmicari : []
        }
    }

    renderTableData() {
        return this.state.takmicari.map((takmicar) => {
            const { id, imeIPrezime, drzava ,visina, email, godinaRodjenja } = takmicar //destructuring
            return (
                <tr key={id}>
                    <td>{imeIPrezime}</td>
                    <td>{drzava}</td>
                    <td>{visina}</td>
                    <td>{godinaRodjenja}</td>
                </tr>
            )
        })
    }

    componentDidMount() {
        fetch("/api/takmicari")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    takmicari : data
                })
            })
    }

    render() {
        return (
            <div>
                <h1 id='title'>React Dynamic Table</h1>
                <table id='takmicari'>
                    <tbody>
                    {this.renderTableData()}
                    </tbody>
                </table>
            </div>
        )
    }

}

export default Homepage