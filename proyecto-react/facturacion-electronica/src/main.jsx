import React from 'react'
import { createRoot } from 'react-dom/client'
import Factura from './components/Factura.jsx'
import Cliente from './components/Cliente.jsx'
import Loggin from './components/Loggin.jsx'
import './css/general.css'


const root = createRoot(document.getElementById('root'))

root.render(<Loggin />);


const validarFrame = (fact,clnt) => {
    if(fact == true){
        root.render(<Factura />);
    }else if(clnt == true){
        root.render(<Cliente />)
    }
}



export default validarFrame

