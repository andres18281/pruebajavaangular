import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelizquierdoComponent } from './panelizquierdo.component';

describe('PanelizquierdoComponent', () => {
  let component: PanelizquierdoComponent;
  let fixture: ComponentFixture<PanelizquierdoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PanelizquierdoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PanelizquierdoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
