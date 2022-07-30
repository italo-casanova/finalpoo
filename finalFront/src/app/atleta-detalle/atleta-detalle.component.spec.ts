import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AtletaDetalleComponent } from './atleta-detalle.component';

describe('AtletaDetalleComponent', () => {
  let component: AtletaDetalleComponent;
  let fixture: ComponentFixture<AtletaDetalleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AtletaDetalleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AtletaDetalleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
