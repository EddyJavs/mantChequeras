import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})


export class apiService{
    private apiClientes = 'http://localhost:8080/clientes';
    private apiCuentas = 'http://localhost:8080/cuentas';
    private apiChequeras = 'http://localhost:8080/chequeras';

    constructor(private httpCliente: HttpClient){

    }

    public getClientes(){
        return this.httpCliente.get<[any]>(this.apiClientes); 
    }

    public deleteClientes(id:Number){
      return this.httpCliente.delete(`${this.apiClientes}/${id}`);
    }

    public saveCliente(cliente: any){
      return this.httpCliente.post(`${this.apiClientes}/crear`, cliente);
    }

    public asignarCuenta(cuenta: any, clienteId:Number){
      return this.httpCliente.post(`${this.apiCuentas}/asignar-cuenta/${clienteId}`, cuenta);
    }

    public getCuentasPorCliente(clienteId: Number){
      return this.httpCliente.get<[any]>(`${this.apiCuentas}/${clienteId}`); 
    }

    public asignarChequera(chequera: any, cuentaId:Number){
      return this.httpCliente.post(`${this.apiChequeras}/asignar-cheque/${cuentaId}`, chequera);
    }

}