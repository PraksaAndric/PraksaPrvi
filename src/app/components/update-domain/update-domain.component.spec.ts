import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateDomainComponent } from './update-domain.component';

describe('UpdateDomainComponent', () => {
  let component: UpdateDomainComponent;
  let fixture: ComponentFixture<UpdateDomainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateDomainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateDomainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
