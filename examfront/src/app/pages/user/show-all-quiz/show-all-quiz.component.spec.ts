import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowAllQuizComponent } from './show-all-quiz.component';

describe('ShowAllQuizComponent', () => {
  let component: ShowAllQuizComponent;
  let fixture: ComponentFixture<ShowAllQuizComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ShowAllQuizComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowAllQuizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
