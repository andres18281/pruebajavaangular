
import { Injectable } from "@angular/core";
import { Observable, map } from "rxjs";
import { HttpClient } from '@angular/common/http';
import { Cliente } from "./cliente.service";
@Injectable({
    providedIn: 'root'
})
export class RequestService {
  private url = 'http://localhost:8080/api'; 
  private crear = this.url+"/clientes";
  constructor(private http: HttpClient){

  }

  CrearCliente(value: any): Observable<any> {
    return this.http.post(this.crear, value, {
      headers: {
        'Content-Type': 'application/json',
      }
    });
  }

  GetClientes(): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(this.crear, {
      headers: {
        'Content-Type': 'application/json'
      }
    });
  }

 

  getBySharedKey(sharedKey: String): Observable<Cliente[]> {
    return this.http.get<Cliente[]>(`${this.url}/clientes?sharedKey=${sharedKey}`, {
      headers: {
        'Content-Type': 'application/json'
      }
    }).pipe(
      map((response: any) => Array.isArray(response) ? response : [response])
    );
  }

  exportClientesToCSV(): Observable<any> {
    const csvExportUrl = `${this.url}/clientes/export/csv`;
    return this.http.get(csvExportUrl, {
      responseType: 'text' // Especifica el tipo de respuesta como texto
    });
  }

  
}