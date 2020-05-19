import { Component, OnInit } from '@angular/core';
import { Domain } from 'src/app/common/domain';
import { Router, ActivatedRoute } from '@angular/router';
import { DomainService } from 'src/app/services/domain.service';



@Component({
  selector: 'app-update-domain',
  templateUrl: './update-domain.component.html',
  styleUrls: ['./update-domain.component.css']
})
export class UpdateDomainComponent implements OnInit {

  id: number;
  domain: Domain;

  constructor(private router: Router,
              private aroute: ActivatedRoute,
              private domainService: DomainService) { }         

  ngOnInit(): void {
   
    this.domain = new Domain();
    this.id = this.aroute.snapshot.params['id'];

    this.domainService.getDomain(this.id).subscribe(
      data => {
        console.log(data);
        this.domain = data;
      },
      error => console.log(error)
    );
  }

  updateDomain(){
    this.domainService.updateDomain(this.id, this.domain).subscribe(
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
   
    this.updateDomain();
  }




}
