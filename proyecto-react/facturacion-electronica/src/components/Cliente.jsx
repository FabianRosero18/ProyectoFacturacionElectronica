import React, { useState } from 'react'
import styles from '../css/cliente.module.css'


const Cliente = () => {

const[id,setId] = useState('');
const[tipo,setTipo] = useState('');
const[nombre,setNombre] = useState('');
const[direccion,setDireccion] = useState('');
const[telefono,setTelefono] = useState('');
const[matricula,setMatricula] = useState('');
const[responsabilidades,setResponsabilidades] = useState('');
const[formaPago,setFormaPago] = useState('');
const[correoFe,setCorreoFe] = useState('');

    return(
        
    <div>
        <h1 className={styles.titulo}>Ingreso de clientes</h1><br></br><br></br>

        <form
            onSubmit={ev => {
                ev.preventDefault()
                alert('!Cliente guardado! si desea guardar otro, puede hacerlo en este momento')

                setId('')
                setTipo('')
                setNombre('')
                setDireccion('')
                setTelefono('')
                setMatricula('')
                setResponsabilidades('')
                setFormaPago('')
                setCorreoFe('')
            }}
        >
            
        <label className={styles.textcolumnuno+' '+styles.label}>ID</label><br></br><br></br>
        <input type="text"  className={styles.columnauno+' '+styles.input} value={id}
        onChange={ev=>{setId(ev.target.value)}}></input><br></br><br></br>
        
        <label className={styles.textcolumnuno+' '+styles.label}>Tipo</label><br></br>
        <input type="text" className={styles.columnauno+' '+styles.input} value={tipo}
        onChange={ev=>{setTipo(ev.target.value)}}></input><br></br><br></br>

        <label className={styles.textcolumnuno+' '+styles.label}>Nombre</label><br></br>
        <input type="text"  className={styles.columnauno+' '+styles.input} value={nombre}
        onChange={ev=>{setNombre(ev.target.value)}}></input><br></br><br></br>

        <label className={styles.textcolumnuno+' '+styles.label}>Direccion</label><br></br>
        <input type="text"  className={styles.columnauno+' '+styles.input} value={direccion}
        onChange={ev=>{setDireccion(ev.target.value)}}></input><br></br><br></br>

        <label className={styles.textcolumnuno+' '+styles.label}>Telefono</label><br></br>
        <input type="text" className={styles.columnauno+' '+styles.input} value={telefono}
        onChange={ev=>{setTelefono(ev.target.value)}}></input><br></br><br></br>

        <div id="mensajeCreacion"></div>

        <label className={styles.textcolumndos+' '+styles.label}>Matricula Mercantil</label><br></br>
        <input type="text"  className={styles.columnados+' '+styles.input} value={matricula}
        onChange={ev=>{setMatricula(ev.target.value)}}></input><br></br><br></br>

        <label className={styles.textcolumndos+' '+styles.label}>Responsabil. Financieras</label><br></br>
        <input type="text"  className={styles.columnados+' '+styles.input} value={responsabilidades}
        onChange={ev=>{setResponsabilidades(ev.target.value)}}></input><br></br><br></br>

        <label className={styles.textcolumndos+' '+styles.label}>Forma de pago</label><br></br>
        <input type="text" className={styles.columnados+' '+styles.input} value={formaPago}
        onChange={ev=>{setFormaPago(ev.target.value)}}></input><br></br><br></br>

        <label className={styles.textcolumndos+' '+styles.label}>Correo para FE</label><br></br>
        <input type="text" className={styles.columnados+' '+styles.input} value={correoFe}
        onChange={ev=>{setCorreoFe(ev.target.value)}}></input><br></br><br></br>
        
        <button type='submit'
        className={styles.button}> Crear Cliente </button><br></br>

        </form>

    </div>

    )
}

export default Cliente