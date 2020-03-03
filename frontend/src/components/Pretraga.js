import React from "react"
import {Container, Form, FormGroup, Input, Label} from "reactstrap";

class Pretraga extends React.Component {
    render() {
        return(
            <Container >
                <h3>Pretraga</h3>
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
                        <Label for="god">Godiste od</Label>
                        <Input type="text" id="god" />
                    </FormGroup>
                    <FormGroup>
                        <Label for="godina">Godiste do</Label>
                        <Input type="text" id="godina" />
                    </FormGroup>
                </Form>
            </Container>
        );
    }
}


export default Pretraga