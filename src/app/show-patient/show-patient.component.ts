import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { throwError } from 'rxjs';
import { PatientService } from '../patient.service';

@Component({
  selector: 'app-show-patient',
  templateUrl: './show-patient.component.html',
  styleUrls: ['./show-patient.component.css']
})
export class ShowPatientComponent implements OnInit {

  patients:any;
  message:any;
  patientId:any;
  tablehide:boolean=false;
  
  


  constructor(private service:PatientService,private router:Router) { }


   public getPatientDetails(patientId:number){
    let response= this.service.getPatient(patientId);
    response.subscribe({
      next:(data)=>this.patients=data,
      error:(err) =>{alert('NO RECORDS FOUND') }
    })
    

   // this.patients=data.patients;

   // console.log("data--",this.patients)
   
   }

  ngOnInit(): void {

     
  }
  back():void{
    this.router.navigate(['']);
  }
 

}
