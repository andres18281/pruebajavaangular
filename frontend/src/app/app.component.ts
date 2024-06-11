import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PanelDerechoComponent } from './panel-derecho/panel-derecho.component';
import { PanelizquierdoComponent } from './panelizquierdo/panelizquierdo.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,PanelDerechoComponent,PanelizquierdoComponent ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
