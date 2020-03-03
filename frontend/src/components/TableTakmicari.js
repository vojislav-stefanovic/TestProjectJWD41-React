import React from "react"
import {Table, Container, Button} from "reactstrap"

class TableTakmicari extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            takmicari : []
        }
    }

    renderTableData() {
        return this.state.takmicari.map((takmicar) => {
            const { id, imeIprezime, drzava ,visina, godinaRodjenja, skakaonicaDTO } = takmicar //destructuring
            return (
                <tr key={id}>
                    <td>{imeIprezime}</td>
                    <td>{drzava}</td>
                    <td>{godinaRodjenja}</td>
                    <td>{visina}</td>
                    <td>{skakaonicaDTO.naziv}</td>
                    <td>
                        <Button color="danger">Obrisi</Button>
                        <Button color="warning">Izmeni</Button>
                        <Button color="primary">Skok</Button>
                    </td>
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
            <Container>
                <div>
                    <h1 id='title'>Takmicari</h1>
                    <Table bordered striped id='takmicari'>
                        <thead >
                        <tr>
                            <th>Ime i prezime</th>
                            <th>Drzava</th>
                            <th>Godina rodjenja</th>
                            <th>Visina</th>
                            <th>Skakaonica</th>
                            <th colspan="3">Actions</th>

                        </tr>
                        </thead>
                        <tbody>
                        {this.renderTableData()}
                        </tbody>
                    </Table>
                </div>
            </Container>
        )
    }

}

export default TableTakmicari