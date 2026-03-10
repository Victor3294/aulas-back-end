const express = require('express');
const { format } = require('date-fns');
const app = express();
const port = 8080;


const data = new Date();
const horarioFormatado = format(data.getTime(), 'hh:mm:ss'); 
const dataFormatada = format(data, 'dd/MM/yyyy');

app.get('/hello', (req, res) => {
  res.send('<html><body><h1>Hello world ! Amapa namora a Isabelo Rodrigues! O amor é lindo!</h1></body></html>');
});

app.get('/hoje', (req, res) => {  
    res.send({"data": dataFormatada});
});

app.get('/horario', (req, res) => {
    res.send({"horario": horarioFormatado});
})

app.get('/agora', (req, res) => {
    res.send({
        "horario": horarioFormatado,
        "data": dataFormatada
    })
})

app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
