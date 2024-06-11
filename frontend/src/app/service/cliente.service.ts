import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

import { RequestService } from './request';

export interface Cliente {
    sharedKey: string;
    businessId: string;
    email: string;
    phone: number;
    dateinitial: string;
    dateend: string;
  }

@Injectable({
  providedIn: 'root'
})
export class ClientesService {
  private mostrarTablaSubject = new BehaviorSubject<boolean>(false);
  private clientesDataSubject = new BehaviorSubject<Cliente[]>([]);

  mostrarTabla$ = this.mostrarTablaSubject.asObservable();
  clientesData$ = this.clientesDataSubject.asObservable();

  constructor(private request: RequestService) {}

 


  


  fetchClientes(text:String) {
    console.log(text)
    if(text == ""){
        console.log("no entra")
        this.request.GetClientes()
        .subscribe( (data: Cliente[]) => {
            console.log("data fetchClientes",data)
            this.clientesDataSubject.next(data);
        });
    }else{
        console.log("entra",text)
        this.request.getBySharedKey(text)
            .subscribe( (data: Cliente[]) => {
                console.log("data fetchClientes",data)
                this.clientesDataSubject.next(data);

            });
    }

    
  }

  exportClientesToCSV() {
    this.request.exportClientesToCSV()
      .subscribe(csvData => {
        this.downloadCSV(csvData, 'clientes.csv');
      }, error => {
        console.error('Error al exportar datos a CSV:', error);
      });
  }
  
  private downloadCSV(data: any, filename: string) {
    const csvContent = 'data:text/csv;charset=utf-8,' + encodeURIComponent(data);
    const link = document.createElement('a');
    link.setAttribute('href', csvContent);
    link.setAttribute('download', filename);
  
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  }

}