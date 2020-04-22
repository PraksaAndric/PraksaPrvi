import { Component, OnInit } from '@angular/core';
import { DomainService } from 'src/app/services/domain.service';
import { Domain } from 'src/app/common/domain';
import { Router } from '@angular/router';


@Component({
  selector: 'app-domain-list',
  templateUrl: './domain-list.component.html',
  styleUrls: ['./domain-list.component.css']
})
export class DomainListComponent implements OnInit {

  domains:Domain[];

  constructor(private domainService: DomainService,
              private router: Router) { }

  ngOnInit(): void {
    
    this.listDomains();

   
  }

  listDomains(){
  
     this.domainService.getDomainList().subscribe(
     data =>  {
      console.log(data);
       this.domains = data;
     }
  
   );
  }

  deleteDomain(id:number){
    this.domainService.deleteDomain(id).subscribe(
      data => {
        console.log(data);
        this.listDomains();
      },
      error => console.log(error)
    );

  }

  updateEmployee(id:number){

    this.router.navigate(['update', id]);
    
  }



}
