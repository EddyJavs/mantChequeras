import { Component, OnInit } from '@angular/core';
import { apiService } from '../api.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit{

  public clientes: any = [];
  public tieneDatos: boolean = false;
  public mensaje: String = '';
  public mostrarFormulario = false;
  protected formulario: FormGroup = new FormGroup({});
  
  constructor(private clientesService: apiService,private formBuilder: FormBuilder){}
  ngOnInit(): void {
    this.consultarClientes();
    this.formulario = this.formBuilder.group({
      nombre: ['', Validators.required],
      direccion: ['', [Validators.required]],
      telefono: ['', [Validators.required]]
    });
  }

  public consultarClientes(){
    this.clientesService.getClientes().subscribe ((data) =>{
      if(data !== null){
        this.clientes = data;
        this.tieneDatos = true;
        console.log(this.clientes);
      }else{
        this.mensaje = 'No se encontraron registros';
        this.tieneDatos = false;
      }

    }, (error) =>{
      this.tieneDatos= false;
      this.mensaje = 'Error al consumir API ';
    })
  }
  
  public async eliminarCliente(id: Number){
    await this.clientesService.deleteClientes(id).subscribe(() => {
      
    });
    this.consultarClientes();
  }

  public async agregarCliente(){
    const post = this.formulario.value;
    await this.clientesService.saveCliente(post).subscribe(response => {
      this.consultarClientes();
    });
    this.consultarClientes();
  }
}
