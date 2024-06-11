import { Component } from '@angular/core';
import { Cliente, ClientesService } from '../service/cliente.service';
import { CommonModule } from '@angular/common'; // Importa CommonModule
@Component({
  selector: 'app-tabla-clientes',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './tabla-clientes.component.html',
  styleUrl: './tabla-clientes.component.css'
})
export class TablaClientesComponent {

  clientes: Cliente[] = [];
  constructor(private clientesService: ClientesService) {
    this.clientesService.clientesData$.subscribe((data: Cliente[]) => {
      console.log("clientesService",data)
      this.clientes = data;
    });
  }

  Editar(id:String){

  }
}
