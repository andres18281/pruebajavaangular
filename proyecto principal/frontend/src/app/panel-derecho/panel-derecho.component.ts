import { Component } from '@angular/core';
import { FormularioComponent } from '../formulario/formulario.component';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { TablaClientesComponent } from '../tabla-clientes/tabla-clientes.component';
import { ClientesService } from '../service/cliente.service';
import { FormsModule } from '@angular/forms'; 
@Component({
  selector: 'app-panel-derecho',
  standalone: true,
  imports: [FormularioComponent,TablaClientesComponent,CommonModule, ReactiveFormsModule,FormsModule ],
  templateUrl: './panel-derecho.component.html',
  styleUrl: './panel-derecho.component.css'
})
export class PanelDerechoComponent {
  textoBuscar: string = "";
  constructor(private clientesService: ClientesService){

  }
  showFormulario:boolean = false;
  Mostrar(){
    console.log("form",this.showFormulario)
    this.showFormulario = !this.showFormulario;
  }

  Buscar(){
    console.log(this.textoBuscar)
    if(this.textoBuscar != ""){
      this.clientesService.fetchClientes(this.textoBuscar);
    }else{
      this.clientesService.fetchClientes("");
    }
    

  }

  Export() {
    this.clientesService.exportClientesToCSV();
  }
}
