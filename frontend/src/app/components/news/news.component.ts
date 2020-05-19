import { Component, OnInit } from '@angular/core';
import { NewsService } from 'src/app/services/news.service';
import { ActivatedRoute, Router } from '@angular/router';
import { News } from 'src/app/common/news';

@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.css']
})
export class NewsComponent implements OnInit {

  link: string;
  news : News = new News();
  idIsNull: boolean = false;

  constructor(private newsService: NewsService,
              private aroute: ActivatedRoute,
              private router: Router ) { }

  ngOnInit(): void {
  }

  getNews(){
    this.newsService.getNews(this.link).subscribe(
      data => {console.log(data),
      this.news = data,
      console.log(this.news.id);
      this.news.id != null ? this.goToDetails(this.news.id) : this.idIsNull = true;
      
      },
      error => console.log(error)
    );

  }

  goToDetails(id:number){
    this.router.navigate(['/details', id]);
  }

  onSubmit(){
    this.getNews();
  }

}
