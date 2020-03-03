import React, {useState} from "react"
import {Form, FormGroup, Container, Label, Input} from 'reactstrap';
import Select from "react-select"

class Forma extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            skakaonice : []
        }
    }

    componentDidMount() {

        fetch("/api/skakaonice")
            .then(response => response.json())
            .then(data => {
                this.setState({
                    skakaonice : data
                })
            })
    }


    renderSkakaonice() {
        return this.state.skakaonice.map((skakaonica) => {
                const {naziv, id} = skakaonica

            return (
                <FormGroup>
                    <Label for="select">Select</Label>
                    <Input type="select" name="select" id="select">
                        <option>{naziv}</option>
                    </Input>
                </FormGroup>
            )
        })
    }

    render() {
        return (
            <Container>
                <Form>
                    <FormGroup>
                        <Label for="ime">Ime i prezime</Label>
                        <Input type="text" id="ime" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="drzava">Drzava</Label>
                        <Input type="text" id="drzava" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="visina">Visina</Label>
                        <Input type="text" id="visina" />
                    </FormGroup>
                    <FormGroup>
                    <Label for="godina">Godina rodjenja</Label>
                    <Input type="text" id="godina" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="email">Email</Label>
                        <Input type="text" id="email" />
                    </FormGroup>
                    {this.renderSkakaonice()}
                </Form>
            </Container>
        )
    }
}

export default Forma