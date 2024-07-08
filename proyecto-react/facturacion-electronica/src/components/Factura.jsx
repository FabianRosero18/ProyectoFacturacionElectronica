import React, { useState } from 'react'
import styles from '../css/factura.module.css'

const Factura = () => {

   const [visibGenEnv,setvisibGenEnv] = useState('hidden')
   const [idCliente,setIdCliente] = useState('')
   const [nombre,setNombre] = useState('')
   const [direccion,setDireccion] = useState('')
   const [telefono,setTelefono] = useState('')
   const [ciudad,setCiudad] = useState('')
   const [idFactura,setIdFactura] = useState('')
   const [fechaRealizacion,setFechaRealizacion] = useState('')
   const [fechaVencimiento,setFechaVencimiento] = useState('')
   const [ordenCompra,setOrdenCompra] = useState('')
   const [remision,setRemision] = useState('')
   const [codigo,setCodigo] = useState('')
   const [descripcion,setDescripcion] = useState('')
   const [cantidad,setCantidad] = useState('')
   const [valorUnd,setValorUnd] = useState('')
   const [observaciones,setObservaciones] = useState('')


   //aqui enviamos los parametros de los input a la base de datos, usando backend seleccionado y inicializamos los campos del item, para agregar mas
   const agregarDatosBdParcial = () => {


      console.log(cantidad*valorUnd)

      setCodigo('')
      setDescripcion('')
      setCantidad('')
      setValorUnd('')

      alert("item guardado con exito")
   }
   //aqui se envia de manera completa todos los datos de la factura a la base de datos
   //solamente se guarda el valor de observaciones y se calcula los impuestos y total, para proceder a mostrar en los campos correspondientes 
   const agregarDatosBdCompleto  = () => {
      alert("Factura creada y guardada. Ya puede proceder a generar y enviar")
   }

   return(

      <div>

      <form 
            onSubmit={
               ev => {
                  ev.preventDefault()
                  //aqui iría la logica para cargar todos los datos del cliente en cada uno de los input, con el backend y la base de datos respectiva
                  if(idCliente === '1'){
                     setNombre('Fabian Rosero')
                     setDireccion('calle 11 No. 22 - 33')
                     setTelefono('4445566')
                     setCiudad('Santiago de cali')
                  }
               }
            }>
         <label id={styles.lid} className={styles.label}>ID cliente</label>
         <input type="text" id={styles.id} name="idCliente" className={styles.input} value={idCliente}
         onChange={ev => setIdCliente(ev.target.value)}></input>

         <label id={styles.lnombre} className={styles.label}>Nombre cliente</label>
         <input type="text" id={styles.nombre} className={styles.input} value={nombre} disabled ></input>

         <label id={styles.ldir} className={styles.label}>Direccion</label><br></br>
         <input type="text" id={styles.direccion} className={styles.input} value={direccion} disabled ></input>

         <label id={styles.ltel} className={styles.label}>Telefono</label><br></br>
         <input type="text" id={styles.telefono} className={styles.input} value={telefono} disabled ></input>

         <label id={styles.lciu} className={styles.label}>Ciudad</label><br></br>
         <input type="text" id={styles.ciudad} className={styles.input} value={ciudad} disabled ></input>

         <button type='submit'  id={styles.buttonCliente} className={styles.button}> Cargar Datos </button>

         <div id={styles.mensajeCreacion}></div>
      </form>

      <form
            onSubmit={ ev => {
               ev.preventDefault()
               agregarDatosBdParcial()

            }}>

         <div id={styles.bloquefactura1}>
         <div className={styles.labelform2+' '+styles.label}>
         <label id={styles.lfactura}>ID factura</label>
         <label id={styles.lfecrel}>Fecha de realizacion</label>
         <label id={styles.lfecven}>Fecha de vencimiento</label>
         <label id={styles.lorcom}>Orden de compra</label>
         <label id={styles.lrem}>Remision</label>
         </div>

         <div className={styles.form2}>
         <input type="text" id="" className={styles.filainput1+' '+styles.input} value={idFactura}
          onChange={ev => setIdFactura(ev.target.value)}></input>     
         <input type="text" id="" className={styles.filainput1+' '+styles.input} value={fechaRealizacion} 
          onChange={ev => setFechaRealizacion(ev.target.value)} placeholder="dd-mm-aaaa"></input>
         <input type="text" id="" className={styles.filainput1+' '+styles.input} value={fechaVencimiento} 
          onChange={ev => setFechaVencimiento(ev.target.value)} placeholder="dd-mm-aaaa"></input>
         <input type="text" id="" className={styles.filainput1+' '+styles.input} value={ordenCompra}
         onChange={ev => setOrdenCompra(ev.target.value)}></input>
         <input type="text" id="" className={styles.filainput1+' '+styles.input} value={remision}
         onChange={ev => setRemision(ev.target.value)}></input>
         </div>
         </div>

         <div id={styles.bloquefactura2}>
         <h2 id={styles.titulo2}>Items de la factura</h2>
         <div className={styles.labelform3}>
         <label id={styles.lcod} className={styles.label}>Codigo</label>
         <label id={styles.ldesc} className={styles.label}>Descripcion</label>
         <label id={styles.lcant} className={styles.label}>Cantidad</label>
         <label id={styles.lvalun} className={styles.label}>Valor unitario</label>
         </div>

         <div className={styles.form3}>
         <input type="text" className={styles.filainput1+' '+styles.input} value={codigo} 
         onChange={ev => setCodigo(ev.target.value)}></input>     
         <input type="text" className={styles.filainput1+' '+styles.input} value={descripcion}
         onChange={ev => setDescripcion(ev.target.value)}></input>
         <input type="text" className={styles.filainput1+' '+styles.input} value={cantidad}
         onChange={ev => setCantidad(ev.target.value)}></input>
         <input type="text" className={styles.filainput1+' '+styles.input} value={valorUnd}
         onChange={ev => setValorUnd(ev.target.value)}></input>
         </div>
         </div>

         <button type='submit' id={styles.buttonItem} className={styles.button}> Agregar Item</button><br></br>
      </form>

         <hr id={styles.barra1} width="100%" size="5"></hr>
    
         <form
            onSubmit={ ev => {
               ev.preventDefault()
               alert("AQUI SE ENVIARA LA FACTURA POR CORREO AL CLIENTE, USANDO LA LOGICA DEL BACKEND")
            }}
         >
         <label id={styles.lobserv} className={styles.label}>Observaciones </label>
         <textarea name="textarea" id={styles.observ} rows="6" cols="80" value={observaciones}
         onChange={ev => setObservaciones(ev.target.value)}
         ></textarea>
         <div className={styles.labelform4+ " " + styles.label}>
         <label>IVA</label><br></br>
         <label>RETEFUENTE</label><br></br>
         <label>TOTAL</label><br></br>
         </div>

         <div className={styles.form4}>
         <input type="text" className={styles.filainput1+' '+styles.input} disabled></input><br></br>     
         <input type="text" className={styles.filainput1+' '+styles.input} disabled></input><br></br> 
         <input type="text" className={styles.filainput1+' '+styles.input} disabled></input><br></br> 
         </div>

         <button 
                  id={styles.buttonGuardar} 
                  className={styles.button}
                  onClick={
                      ev => {
                        ev.preventDefault()
                        setvisibGenEnv('visible')
                        agregarDatosBdCompleto()}
                  }>Guardar</button><br></br>
         <button
               type='submit' 
               id={styles.buttonEnviar} 
               className={styles.button}
               style={
                  {visibility:visibGenEnv}
               }>Generar y enviar</button><br></br>
      </form>


      </div>
      //<div>entro a factura</div>
   )
}


export default Factura