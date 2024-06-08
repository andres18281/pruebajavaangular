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

}