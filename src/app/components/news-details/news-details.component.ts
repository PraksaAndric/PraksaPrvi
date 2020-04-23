import { Component, OnInit } from '@angular/core';
import { News } from 'src/app/common/news';
import { NewsService } from 'src/app/services/news.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-news-details',
  templateUrl: './news-details.component.html',
  styleUrls: ['./news-details.component.css']
})
export class NewsDetailsComponent implements OnInit {

  id:number;
  news: News;

  constructor(private newsService : NewsService,
    private router: Router,
    private aroute: ActivatedRoute) { }

  ngOnInit(): void {
    this.news = new News();
    this.id = this.aroute.snapshot.params['id'];

    this.newsService.getNewsById(this.id).subscribe(
      data => {
        console.log(data);
        this.news = data;
      },
      error => console.log(error)
    );
  }

  getAudio(){
    this.id = this.aroute.snapshot.params['id'];
    this.newsService.getAudio(this.id).subscribe(
      data => console.log(data),
      error => console.log(error)
    );
  }

}
