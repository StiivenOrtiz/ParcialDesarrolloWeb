import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListLibrariesComponent } from './list-libraries.component';

describe('ListLibrariesComponent', () => {
  let component: ListLibrariesComponent;
  let fixture: ComponentFixture<ListLibrariesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ListLibrariesComponent]
    });
    fixture = TestBed.createComponent(ListLibrariesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
