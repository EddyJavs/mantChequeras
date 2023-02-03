import { Component, EventEmitter } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { apiService } from '../api.service';

@Component({
  selector: 'app-chequeras',
  templateUrl: './chequeras.component.html',
  styleUrls: ['./chequeras.component.css']
})
export class ChequerasComponent {
  public clientes: any = [];
  public cuentas: any = [];

  protected formulario: FormGroup = new FormGroup({});

  constructor(private chequerasService: apiService,private formBuilder: FormBuilder){}

  ngOnInit(): void {
    this.consultarClientes();
    this.formulario = this.formBuilder.group({
      clienteId: ['', Validators.required],
      cuentaId: ['', [Validators.required]]
    });

  }

  public consultarClientes(){
    this.chequerasService.getClientes().subscribe ((data) =>{
        this.clientes = data;
        });
  }

  public consultarCuentasPorCliente(event: Event){
    const clienteId = this.formulario.value.clienteId;
    if(clienteId === null){
      return;
    }
    this.chequerasService.getCuentasPorCliente(clienteId).subscribe ((data) =>{
        this.cuentas = data;
        });
  }

  public async asignarChequera(){
    const cheque = this.formulario.value;
    await this.chequerasService.asignarChequera(cheque,cheque.cuentaId).subscribe((data) =>{
      });
    this.formulario.patchValue({});
  }
}
