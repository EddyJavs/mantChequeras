import { Component, OnInit } from '@angular/core';
import { apiService } from '../api.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-cuentas',
  templateUrl: './cuentas.component.html',
  styleUrls: ['./cuentas.component.css']
})
export class CuentasComponent {

  public clientes: any = [];
  public tiposCuentas: any = [];

  protected formulario: FormGroup = new FormGroup({});

  constructor(private cuentasService: apiService,private formBuilder: FormBuilder){}

  ngOnInit(): void {
    this.consultarClientes();
    this.formulario = this.formBuilder.group({
      clienteId: ['', Validators.required],
      tipoCuenta: ['', [Validators.required]],
      monto: [0.0, [Validators.required]]
    });

  }

  public consultarClientes(){
    this.cuentasService.getClientes().subscribe ((data) =>{
        this.clientes = data;
        });
  }

  public async asignarCuenta(){
    const cuenta = this.formulario.value;
    await this.cuentasService.asignarCuenta(cuenta,cuenta.clienteId).subscribe((data) =>{
      });
    this.formulario.patchValue({});
  }
}
