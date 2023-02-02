import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})


export class apiService{
    private apiClientes = 'http://localhost:8080/clientes';

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

}