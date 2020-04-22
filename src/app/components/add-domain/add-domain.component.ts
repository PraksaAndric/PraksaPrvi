import { Component, OnInit } from '@angular/core';

import { DomainService } from 'src/app/services/domain.service';
import { Router } from '@angular/router';
import { Domain } from 'src/app/common/domain';

@Component({
  selector: 'app-add-domain',
  templateUrl: './add-domain.component.html',
  styleUrls: ['./add-domain.component.css']
})
export class AddDomainComponent implements OnInit {

  domain: Domain = new Domain();

  constructor(private domainService: DomainService,
              private router: Router) { }

  ngOnInit(): void {
  }

  addDomain(){
    this.domainService.addDomain(this.domain).subscribe(
      data => console.log(data),
      error => console.log(error)
    );
    this.domain = new Domain();
    this.gotoList();

  }

  gotoList(){
    this.router.navigate(['/domains']);
  }

  onSubmit(){
   
    this.addDomain();
  }

}
