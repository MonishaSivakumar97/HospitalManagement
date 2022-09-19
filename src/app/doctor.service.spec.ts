import { HttpClient } from '@angular/common/http';
import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { Doctor } from './doctor';

import { DoctorService } from './doctor.service';

describe('DoctorService', () => {
 let service: DoctorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DoctorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
describe('DoctorService',() => {
  let httpClientSpy: jasmine.SpyObj<HttpClient>;
  let service:DoctorService
  
  beforeEach(() => {
    service = TestBed.inject(DoctorService);
    httpClientSpy = jasmine.createSpyObj('HttpClient',['get']);
    service = new DoctorService(httpClientSpy);
  })
  describe('getDoctorList()',() => {
    it('should return Doctor List', () => {
      let POST:Doctor[] = [
        {
          id:1,
          name: "Ramana",
          gender:"Male",
          specialist: "ent",
          numberOfPatients: 10 ,
          age:24
        },
        {
          id:2,
          name: "JK",
          gender:"Female",
          specialist: "Brain",
          numberOfPatients: 3 ,
          age:23
        },{
          id:3,
          name: "sri",
          gender:"Male",
          specialist: "Brain",
          numberOfPatients: 3 ,
          age:34
        },{
          id:4,
          name: "lakshmi",
          gender:"Female",
          specialist: "mental disorder",
          numberOfPatients: 1 ,
          age:22
        },{
          id:5,
          name: "VL",
          gender:"Female",
          specialist: "psycharstist",
          numberOfPatients: 1 ,
          age:55
        },
        {
          id:6,
          name: "chnd",
          gender:"Male",
          specialist: "rt",
          numberOfPatients: 3 ,
          age:24
        },
      ]
      httpClientSpy.get.and.returnValue(of(POST));
      service.getDoctorList().subscribe({
        next: (post) => {
         // expect(post).toEqual(POST);
        },
        error: () => {}, 
      })
      expect(httpClientSpy.get).toHaveBeenCalledTimes(1);
    })
  })
})
