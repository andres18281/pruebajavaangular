import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { RequestService } from '../service/request';

@Component({
  selector: 'app-formulario',
  standalone: true,
  imports: [ReactiveFormsModule ],
  templateUrl: './formulario.component.html',
  styleUrl: './formulario.component.css'
})
export class FormularioComponent implements OnInit {
  myForm: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder,
              private service:RequestService) {

              }

  ngOnInit(): void {
    this.myForm = this.formBuilder.group({
      businessId: ['', Validators.required],
      phone: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      dateinitial: ['', Validators.required],
      dateend: ['', Validators.required]
    });
  }

  onSubmit(): void {
    console.log(this.myForm.valid)
    if (this.myForm.valid) {
      console.log(this.myForm.value);
      this.service.CrearCliente(this.myForm.value).subscribe(
        response => {
          console.log('Cliente creado con éxito', response);
        },
        error => {
          console.error('Error al crear cliente', error);
        }
      );
      // Aquí puedes agregar la lógica para enviar los datos del formulario
    }else{
      console.log(this.myForm.valid)
    }
  }
}
