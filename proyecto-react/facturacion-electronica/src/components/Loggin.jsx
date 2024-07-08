/* eslint-disable react/prop-types */

import React  from 'react'
import {useState} from 'react'
import validarFrame from '../main.jsx'
//modularizacion de css, hay que adicionar el .module al archivo css para que pueda importarlo adecuadamente
import styles from '../css/loggin.module.css'



const Loggin = () => {

    //declarando una variable de estado, llamada user, para capturar valor de input
    //toda variable en react funciona a modo de estados, asi:
    const [user, setUser] = useState('')
    const [pass, setPass] = useState('')
    const [fallo, setFallo] = useState('hidden');
    const [menu, setMenu] = useState('hidden')
    

    return(
        <div>
            <form 
            //utilizacion del objeto creado con la modularizacion de css
            className={styles.form}
                onSubmit={ ev=> {
                    //aqui prevenimos que el formulario se envie, ya que es  tipo 'submit'
                    ev.preventDefault()
                    console.log(user);
                    console.log(pass);
                        if((user === 'admin' && pass === 's2010')||(user === 'facturacion' && pass === 's2020')){

                            setMenu('visible')

                        }
                        else setFallo('visible')
                    }
                }
               
            >
            <h1 className={styles.titulo}>Iniciar sesion</h1>
            <label className={styles.label}>Usuario</label>
            <br></br>
            <input  
                type='text'
                className={styles.input}
                value={user}
                //aqui capturamos el valor digitado en este input
                onChange={ ev => setUser(ev.target.value)}
            ></input>
            <br></br>
            <label className={styles.label}>Contraseña</label>
            <br></br>
            <input 
                type="password" 
                className={styles.input}
                value={pass}
                onChange={ev => setPass(ev.target.value)}
            ></input>   
            <br></br>
            <div
                style = {{
                    visibility:menu,
                    position: 'relative',
                    top: '-40px'
                }}>
                <button
                className={styles.button}
                onClick={()=>{validarFrame(false,true)
                }}>
                    Crear cliente</button>
                <button
                className={styles.button}
                onClick={()=>{validarFrame(true,false)
                    }}>
                Crear factura</button>
            </div>
            <p
                style={{
                    visibility:fallo
                }}>
            USUARIO O CONTRASEÑA INCORRECTOS
            </p>

            <button
                type='submit' 
                className={styles.button}
            > Inicio </button>
        </form>

        </div>

    );
};



export default Loggin;