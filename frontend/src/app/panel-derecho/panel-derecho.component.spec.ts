import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PanelDerechoComponent } from './panel-derecho.component';

describe('PanelDerechoComponent', () => {
  let component: PanelDerechoComponent;
  let fixture: ComponentFixture<PanelDerechoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PanelDerechoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PanelDerechoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
